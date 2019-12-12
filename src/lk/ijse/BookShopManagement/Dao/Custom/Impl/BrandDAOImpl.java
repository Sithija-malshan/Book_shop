/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.BookShopManagement.Dao.CrudUtil;
import lk.ijse.BookShopManagement.Dao.Custom.BrandDAO;
import lk.ijse.BookShopManagement.Entity.Brand;

/**
 *
 * @author malsh
 */
public class BrandDAOImpl implements BrandDAO{

    @Override
    public boolean add(Brand t) throws Exception {
        return CrudUtil.executeUpdate("insert into brand values(?,?)", t.getId(), t.getName());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Brand t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Brand search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from brand where brandId=?", id);
        Brand brand = null;
        while (rst.next()) {            
            brand = new Brand(rst.getString(1), rst.getString(2));
        }
        return brand;
    }

    @Override
    public ArrayList<Brand> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from brand");
        ArrayList<Brand> allBrands = new ArrayList<>();
        while (rst.next()) {            
            Brand b = new Brand(rst.getString(1), rst.getString(2));
            allBrands.add(b);
        }
        return allBrands;
    }
    
}
