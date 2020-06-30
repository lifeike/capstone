package services;

import dataaccess.CategoriesDB;
import java.util.List;
import models.Category;

/**
 *
 * @author 794473
 */
public class CategoryService {

    /**
     *
     * @return
     * @throws Exception
     */
    public List<Category> getAll() throws Exception {
        CategoriesDB db = new CategoriesDB();

        List<Category> cat;
        cat = db.getAll();

        return cat;
    }

    /**
     *
     * @param catname
     */
    public void add(String catname) {
        CategoriesDB db = new CategoriesDB();
        Category category = new Category(0, catname);

        db.insert(category);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Category getCategory(int id) throws Exception {
        CategoriesDB db = new CategoriesDB();
        Category cat = db.getCategory(id);
        return cat;
    }

    /**
     *
     * @param id
     * @param name
     * @throws Exception
     */
    public void update(int id, String name) throws Exception {
        CategoriesDB db = new CategoriesDB();
        Category category = db.getCategory(id);

        category.setCategoryDescription(name);

        db.update(category);
    }

}
