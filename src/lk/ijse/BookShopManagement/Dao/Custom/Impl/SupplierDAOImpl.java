/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.BookShopManagement.Dao.CrudUtil;
import lk.ijse.BookShopManagement.Dao.Custom.SupplierDAO;
import lk.ijse.BookShopManagement.Entity.Supplier;

/**
 *
 * @author malsh
 */
public class SupplierDAOImpl implements SupplierDAO{

    @Override
    public boolean add(Supplier t) throws Exception {
        return CrudUtil.executeUpdate("insert into supplier values(?,?,?,?)", t.getId(), t.getName(), t.getContact(), t.getAddress());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from supplier where sId=?", id);
    }

    @Override
    public boolean update(Supplier t) throws Exception {
        return CrudUtil.executeUpdate("update supplier set name=?,contact=?,address=? where sId=?", t.getName(), t.getContact(), t.getAddress(), t.getId());
    }

    @Override
    public Supplier search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from supplier where sId=?", id);
        Supplier supplier = null;
        while (rst.next()) {            
            supplier = new Supplier(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4));
        }
        return supplier;
    }

    @Override
    public ArrayList<Supplier> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from supplier");
        ArrayList<Supplier> allSuppliers = new ArrayList<>();
        while (rst.next()) {            
            Supplier s = new Supplier(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4));
            allSuppliers.add(s);
        }
        return allSuppliers;
    }

    @Override
    public String getLastID() throws Exception {
        String sql = "select sId from supplier order by sId desc limit 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        if (rst.next()) {
            String id = rst.getString(1);
            id = id.split("[A-Z]")[1];
            id = (Integer.parseInt(id)+1) + "";
            return "S00" + id;
        } else {
            return "S001";
        }
    }

    @Override
    public ArrayList<Supplier> getSearchSupplier(String field, String keyword) throws Exception {
        String sql = "select * from supplier where name like ? ";
        String key = "%" + keyword + "%";
        ResultSet rst = CrudUtil.executeQuery(sql, key);
        ArrayList<Supplier> suppliers = new ArrayList<>();
        while (rst.next()) {            
            suppliers.add(new Supplier(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4)));
        }
        return suppliers;
    }
    
}
