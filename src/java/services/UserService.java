package services;

import dataaccess.*;
import java.util.List;
import models.Provinces;
import models.Roles;
import models.User;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class UserService {

    /**
     *
     * @param email
     * @return
     * @throws Exception
     */
    public User get(String email) throws Exception {
        UserDB db = new UserDB();
        User user = db.getUser(email);
        return user;

    }

    /**
     *
     * @return @throws Exception
     */
    public List<User> getAll() throws Exception {
        UserDB db = new UserDB();
        List<User> users;
        users = db.getAll();
        return users;
    }

    /**
     *
     * @param email
     * @throws Exception
     */
    public void deactivate(String email) throws Exception {
        UserDB db = new UserDB();
        User user = db.getUser(email);

        user.setStatus(false);
        db.update(user);
    }

    /**
     *
     * @param email
     * @throws Exception
     */
    public void activate(String email) throws Exception {
        UserDB db = new UserDB();
        User user = db.getUser(email);

        user.setStatus(true);
        db.update(user);
    }

    /**
     *
     * @param email
     * @param fname
     * @param lname
     * @param password
     * @param value
     * @param phone
     * @param address
     * @param postalcode
     * @param city
     * @param province
     */
    public void insert(String email, String fname, String lname, String password, String value, String phone, String address, String postalcode, String city, int province) {

        UserDB db = new UserDB();

        RoleDB roleDB = new RoleDB();
        Roles role = roleDB.getRole(2);

        ProvinceListDB provDB = new ProvinceListDB();
        Provinces prov = provDB.getProvince(province);

        User user = new User(email, fname, lname, phone, address, postalcode, city, password, value, true);
        user.setRole(role);
        user.setProvince(prov);
        user.setStatus(false);
        db.insert(user);

    }

    /**
     *
     * @param email
     * @param fname
     * @param lname
     * @param password
     * @param value
     * @param phone
     * @param address
     * @param pcode
     * @param city
     * @param provid
     * @throws Exception
     */
    public void updateProfile(String email, String fname, String lname, String password, String value, String phone, String address, String pcode, String city, String provid) throws Exception {
        UserDB db = new UserDB();
        User user = db.getUser(email);

        user.setFirstName(fname);
        user.setLastName(lname);
        user.setPassword(password);
        user.setPostalCode(pcode);
        user.setAddress(address);
        user.setSalt(value);
        user.setPhone(phone);
        user.setCity(city);

        int id = Integer.parseInt(provid);
        ProvinceListDB prov = new ProvinceListDB();
        Provinces p = prov.getProvince(id);
        user.setProvince(p);

        db.update(user);

    }

    /**
     *
     * @return @throws Exception
     */
    public List<User> getAllInactive() throws Exception {
        UserDB db = new UserDB();
        List<User> users;
        users = db.getAllInactive();
        return users;
    }

    /**
     *
     * @param uuid
     * @return
     */
    public User getByUUID(String uuid) {

        UserDB udb = new UserDB();
        User u = udb.getByUUID(uuid);

        return u;
    }

    /**
     *
     * @param uuid
     * @return
     */
    public User getByUUIDactivate(String uuid) {

        UserDB udb = new UserDB();
        User u = udb.getByUUIDactivate(uuid);

        return u;
    }

    /**
     *
     * @param uuid
     * @return
     */
    public User getByUUIDreset(String uuid) {

        UserDB udb = new UserDB();
        User u = udb.getByUUIDreset(uuid);

        return u;
    }

    /**
     *
     * @param email
     * @param fname
     * @param lname
     * @param phone
     * @param address
     * @param pcode
     * @param city
     * @param provid
     * @param rid
     * @throws Exception
     */
    public void updateByAdmin(String email, String fname, String lname, String phone, String address, String pcode, String city, String provid, String rid) throws Exception {
        UserDB db = new UserDB();
        User user = db.getUser(email);

        user.setFirstName(fname);
        user.setLastName(lname);
        user.setPostalCode(pcode);
        user.setAddress(address);
        user.setPhone(phone);
        user.setCity(city);


        int id = Integer.parseInt(provid);
        ProvinceListDB prov = new ProvinceListDB();
        Provinces p = prov.getProvince(id);
        user.setProvince(p);

        int roleid = Integer.parseInt(rid);
        RoleDB rdb = new RoleDB();
        Roles r = rdb.getRole(roleid);
        
        user.setRole(r);

        db.update(user);

    }

}
