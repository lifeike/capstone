package services;

import dataaccess.UserDB;
import java.util.HashMap;
import java.util.UUID;
import models.User;
import static utilities.PasswordUtil.hashAndSaltPassword;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class AccountService {

    /**
     *
     * @param loginEmail
     * @param loginPassword
     * @return login
     * @throws Exception
     */
    public User login(String loginEmail, String loginPassword) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.getUser(loginEmail);

        if (user == null) {
            return null;
        }
        String salt = user.getSalt();

        String hashPass = hashAndSaltPassword(loginPassword, salt);

        if (!user.getPassword().equals(hashPass)) {
            return null;
        }

        return user;
    }

    /**
     *
     * @param email
     * @param path
     * @param url
     * @return 
     * @throws Exception
     */
    public User resetPassword(String email, String path, String url) throws Exception {
        String uuid = UUID.randomUUID().toString();

        UserDB userDB = new UserDB();
        User user = null;
        try {
            user = userDB.getUser(email);
            user.setPasswordResetUUID(uuid);
            userDB.update(user);
        } catch (Exception ex) {
        }
        if (user == null) {
            return null;
        }
        String link = url + "?uuid=" + uuid;

        String to = user.getEmail();
        String subject = "C&C - Password Reset";
        String template = path + "/emailtemplates/reset.html";
        HashMap<String, String> tags = new HashMap<>();
        tags.put("firstname", user.getFirstName());
        tags.put("email", user.getEmail());
        tags.put("link", link);

        GmailService.sendMail(to, subject, template, tags);

        return user;

    }

    /**
     *
     * @param uuid
     * @param password
     * @return
     */
    public boolean changePassword(String uuid, String password) {
        UserService us = new UserService();
        try {
            User user = us.getByUUID(uuid);
            user.setPassword(password);
            user.setPasswordResetUUID(null);
            UserDB ur = new UserDB();
            ur.update(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * @param email
     * @param path
     * @param url
     * @return
     * @throws Exception
     */
    public User activateaccountlink(String email, String path, String url) throws Exception {
        String uuid = UUID.randomUUID().toString();

        UserDB userDB = new UserDB();
        User user = null;
        try {
            user = userDB.getUser(email);
            user.setActivationUUID(uuid);
            userDB.update(user);
        } catch (Exception ex) {
        }
        if (user == null) {
            return null;
        }
        String link = url + "?uuid=" + uuid;

        String to = user.getEmail();
        String subject = "C&C - Account Activation Link";
        String template = path + "/emailtemplates/activate.html";
        HashMap<String, String> tags = new HashMap<>();
        tags.put("firstname", user.getFirstName());
        tags.put("email", user.getEmail());
        tags.put("link", link);

        GmailService.sendMail(to, subject, template, tags);

        return user;

    }

    /**
     *
     * @param uuid
     * @param path
     * @return
     * @throws Exception
     */
    public User welcome(String uuid, String path) throws Exception {

        UserDB userDB = new UserDB();
        User user = null;
        try {
            user = userDB.getByUUIDactivate(uuid);

        } catch (Exception ex) {
        }
        if (user == null) {
            return null;
        }

        String to = user.getEmail();
        String subject = " C&C - WELCOME";
        String template = path + "/emailtemplates/welcome.html";
        HashMap<String, String> tags = new HashMap<>();
        tags.put("firstname", user.getFirstName());

        GmailService.sendMail(to, subject, template, tags);

        return user;

    }

    /**
     *
     * @param email
     * @param od
     * @param on
     * @param total
     * @param path
     * @return
     * @throws Exception
     */
    public User oce(String email, String od, String on, String total, String path) throws Exception {

        UserDB userDB = new UserDB();
        User user = null;
        try {
            user = userDB.getUser(email);

        } catch (Exception ex) {
        }
        if (user == null) {
            return null;
        }

        String to = user.getEmail();
        String subject = " C&C - Order Confirmation";
        String template = path + "/emailtemplates/order.html";
        HashMap<String, String> tags = new HashMap<>();
        tags.put("firstname", user.getFirstName());
        tags.put("ordernumber", on);
        tags.put("date", od);
        tags.put("price", total);

        GmailService.sendMail(to, subject, template, tags);

        return user;

    }

    /**
     *
     * @param uuid
     * @return
     */
    public boolean activate(String uuid) {
        UserService us = new UserService();

        try {
            User user = us.getByUUIDactivate(uuid);

            user.setStatus(true);
            user.setActivationUUID(null);

            UserDB ur = new UserDB();

            ur.update(user);

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * @param uuid
     * @param password
     * @param salt
     * @return
     */
    public boolean changePassword(String uuid, String password, String salt) {
        UserService us = new UserService();
        try {
            User user = us.getByUUIDreset(uuid);

            user.setPassword(password);
            user.setSalt(salt);

            user.setPasswordResetUUID(null);
            UserDB ur = new UserDB();
            ur.update(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
