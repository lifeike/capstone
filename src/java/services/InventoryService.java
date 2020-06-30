package services;

import dataaccess.CategoriesDB;
import dataaccess.ItemsDB;
import java.util.List;
import models.Category;
import models.Item;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class InventoryService {

    /**
     *
     * @return @throws Exception
     */
    public List<Item> getAllActive() throws Exception {
        ItemsDB db = new ItemsDB();
        List<Item> item;
        item = db.getAllActive();
        return item;
    }

    /**
     *
     * @param upsc
     * @return
     * @throws Exception
     */
    public Item get(String upsc) throws Exception {
        ItemsDB db = new ItemsDB();
        Item item = db.getItem(upsc);
        return item;
    }

    /**
     *
     * @param upsc
     * @param name
     * @param description
     * @param cost
     * @param retail
     * @param catid
     * @param imageLink
     * @param quantity
     */
    public void add(String upsc, String name, String description, double cost, double retail,
            int catid, String imageLink, int quantity) {

        ItemsDB db = new ItemsDB();

        CategoriesDB catDB = new CategoriesDB();

        Category cat = catDB.getCategory(catid);

        Item it = new Item(upsc, name, description, cost, retail, imageLink, quantity, true);
        it.setCategory(cat);

        db.insert(it);

    }

    /**
     *
     * @param upsc
     * @param name
     * @param description
     * @param cost
     * @param retail
     * @param catid
     * @param imageLink
     * @param quantity
     * @throws Exception
     */
    public void update(String upsc, String name, String description, double cost, double retail, int catid, String imageLink, int quantity) throws Exception {
        ItemsDB db = new ItemsDB();
        Item item = db.getItem(upsc);

        CategoriesDB catDB = new CategoriesDB();
        Category cat = catDB.getCategory(catid);

        item.setUpsc(upsc);
        item.setName(name);
        item.setDescription(description);
        item.setCost(cost);
        item.setRetailCost(retail);
        item.setCategory(cat);
        item.setImageLink(imageLink);
        item.setQuantity(quantity);
        item.setStatus(true);

        db.update(item);

    }

    /**
     *
     * @param upsc
     * @param quantity
     * @throws Exception
     */
    public void updateProductQuantity(String upsc, int quantity) throws Exception {
        ItemsDB db = new ItemsDB();
        Item item = db.getItem(upsc);

        item.setQuantity(quantity);

        db.update(item);

    }

    /**
     *
     * @param code
     * @throws Exception
     */
    public void deactivate(String code) throws Exception {
        ItemsDB db = new ItemsDB();
        Item item = db.getItem(code);
        item.setStatus(false);
        db.update(item);
    }

    /**
     *
     * @return @throws Exception
     */
    public List<Item> getAllInactive() throws Exception {
        ItemsDB db = new ItemsDB();
        List<Item> users;
        users = db.getAllInactive();
        return users;
    }

    /**
     *
     * @param code
     * @throws Exception
     */
    public void activate(String code) throws Exception {
        ItemsDB db = new ItemsDB();
        Item item = db.getItem(code);
        item.setStatus(true);
        db.update(item);
    }

}
