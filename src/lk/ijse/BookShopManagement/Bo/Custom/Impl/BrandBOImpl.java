/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.Custom.BrandBO;
import lk.ijse.BookShopManagement.Dao.Custom.BrandDAO;
import lk.ijse.BookShopManagement.Dao.DAOFactory;
import lk.ijse.BookShopManagement.Dto.BrandDTO;
import lk.ijse.BookShopManagement.Entity.Brand;

/**
 *
 * @author malsh
 */
public class BrandBOImpl implements BrandBO {
    BrandDAO dAO = (BrandDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.BRAND);

    @Override
    public boolean add(BrandDTO brand) throws Exception {
        return dAO.add(new Brand(brand.getId(), brand.getName()));
    }

    @Override
    public ArrayList<BrandDTO> getAllBrands() throws Exception {
        ArrayList<Brand> all = dAO.getAll();
        ArrayList<BrandDTO> allBrand = new ArrayList<>();
        for (Brand b : all) {
            allBrand.add(new BrandDTO(b.getId(), b.getName()));
        }
        return allBrand;
    }

    @Override
    public BrandDTO searchBrand(String id) throws Exception {
        Brand b = dAO.search(id);
        return  new BrandDTO(b.getId(), b.getName());
    }
    
}
