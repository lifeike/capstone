package services;

import dataaccess.ContactDB;
import java.util.List;
import models.Contact;

/**
 *
 * @author 794473
 */
public class ContactService {

    /**
     *
     * @param name
     * @param email
     * @param message
     */
    public void add(String name, String email, String message) {

        ContactDB db = new ContactDB();

        Contact c = new Contact(0,name, email, message);

        db.insert(c);

    }

    /**
     *
     * @return
     * @throws Exception
     */
    public List<Contact> getAll() throws Exception {
        ContactDB db = new ContactDB();

        List<Contact> c;
        c = db.getAll();

        return c;
    }

}
