package services;

import dataaccess.ItemsDB;
import models.Item;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class ShopItemService {

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Item getItem(String id) throws Exception {
        ItemsDB db = new ItemsDB();
        Item item = db.getItem(id);
        return item;
    }

}
