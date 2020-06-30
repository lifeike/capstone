package services;


import dataaccess.ProvinceListDB;
import java.util.List;
import models.Provinces;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class ProvinceListService {
    
    /**
     *
     * @return
     * @throws Exception
     */
    public List<Provinces> getAll() throws Exception {
        ProvinceListDB db = new ProvinceListDB();

        List<Provinces> prov;
        prov = db.getAll();

        return prov;
    }
    
    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Provinces getProvince(int id) throws Exception {
        ProvinceListDB db = new ProvinceListDB();

       Provinces prov = db.getProvince(id);
        return prov;

        }
}
