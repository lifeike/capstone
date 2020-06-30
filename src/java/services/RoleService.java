package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Roles;

/**
 *
 * @author 794473
 */
public class RoleService {

    /**
     *
     * @return
     * @throws Exception
     */
    public List<Roles> getAll() throws Exception {
        RoleDB db = new RoleDB();

        List<Roles> roles;
        roles = db.getAll();

        return roles;
    }
}
