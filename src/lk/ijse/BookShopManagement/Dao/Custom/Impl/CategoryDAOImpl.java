/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.BookShopManagement.Dao.CrudUtil;
import lk.ijse.BookShopManagement.Dao.Custom.CategoryDAO;
import lk.ijse.BookShopManagement.Entity.Category;

/**
 *
 * @author malsh
 */
public class CategoryDAOImpl implements CategoryDAO{

    @Override
    public boolean add(Category t) throws Exception {
        return CrudUtil.executeUpdate("insert into category values(?,?)", t.getId(), t.getName());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Category t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from category where CID=?", id);
        Category category = null;
        while (rst.next()) {            
            category = new Category(rst.getString(1), rst.getString(2));
        }
        return category;
    }

    @Override
    public ArrayList<Category> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from category");
        ArrayList<Category> allCategory = new ArrayList<>();
        while (rst.next()) {            
            Category c = new Category(rst.getString(1), rst.getString(2));
            allCategory.add(c);
        }
        return allCategory;
    }
    
}
