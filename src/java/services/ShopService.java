package services;

import dataaccess.ItemsDB;
import java.util.List;
import models.Item;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class ShopService {

    /**
     *
     * @return
     * @throws Exception
     */
    public List<Item> getAll() throws Exception {
        ItemsDB db = new ItemsDB();
        List<Item> item;
        item = db.getAllActive();
        return item;
    }

}
