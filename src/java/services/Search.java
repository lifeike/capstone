/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import dataaccess.CategoriesDB;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.websocket.Session;
import models.Category;
import models.Item;
import utilities.DBUtil;

/**
 *
 * @author 792240
 */
public class Search {
        
    EntityManager em = DBUtil.getEmFactory().createEntityManager();

    /**
     *
     * @param keyword
     * @return
     * @throws Exception
     */
    public List<Item> searchResult(String keyword) throws Exception{
        
        // return result set 
        List<Item> result = new ArrayList<Item>();
        int keyC = 0;
        
        //in case user input two words, search by each one and join items to arraylist
        String[] searchArray = keyword.split(" ");
        CategoriesDB cdb = new CategoriesDB();
        List<Category> listCategory = cdb.getAll();
        
       
        for(String s: searchArray){
            
            // search category 
            for(Category c : listCategory){
            String key = s;
            if(c.getCategoryDescription().contains(key)){
                keyC = c.getCategoryID();
                Query queryC = em.createQuery("Select c FROM Item c WHERE c.category = :key");
                queryC.setParameter("key",keyC);            
                result.addAll(queryC.getResultList());
            }else{
                key="%"+s+"%";
            }
            
            // search by upsc and description
            Query query = em.createQuery("Select e FROM Item e WHERE e.description LIKE :key");
            query.setParameter("key",key);
            result.addAll(query.getResultList());
            
            Query queryU = em.createQuery("Select c FROM Item c WHERE c.upsc LIKE :key");
            queryU.setParameter("key",key);
            result.addAll(queryU.getResultList());                      
         }
        }
        
        //check and get rid of repeated result
        List<Item> finalResult = new ArrayList<Item>();
        for(Item i:result){
            int id = i.getCategory().getCategoryID();
            boolean add = true;
            
            for(Item fi:finalResult){
                if(fi.getCategory().getCategoryID()==id){
                    add = false;
                    break;
                }
            }
            
            if(add==true){
                finalResult.add(i);
            }
        }     
        
        //final result return to Inventory Servlet
        return finalResult;
 
    }
}
