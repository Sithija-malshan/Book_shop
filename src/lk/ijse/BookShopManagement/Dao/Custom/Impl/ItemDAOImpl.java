/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.BookShopManagement.Dao.CrudUtil;
import lk.ijse.BookShopManagement.Dao.Custom.ItemDAO;
import lk.ijse.BookShopManagement.Entity.Item;

/**
 *
 * @author malsh
 */
public class ItemDAOImpl implements ItemDAO{

    @Override
    public boolean add(Item t) throws Exception {
        return CrudUtil.executeUpdate("insert into item values(?,?,?,?,?,?,?)", t.getItemCode(), t.getDescription(), t.getCategoryID(), t.getBrandID(), t.getCost(), t.getSale(), t.getQty());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from item where itemId=?", id);
    }

    @Override
    public boolean update(Item t) throws Exception {
        return CrudUtil.executeUpdate("update item set description=?,CID=?,brandId=?,costPrice=?,salePrice=?,qty=? where itemId=?", t.getDescription(), t.getCategoryID(), t.getBrandID(), t.getCost(), t.getSale(), t.getQty(), t.getItemCode());
    }

    @Override
    public Item search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from item where itemId=?", id);
        Item item = null;
        while (rst.next()) {
            item = new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5), rst.getDouble(6), rst.getInt(7));
        }
        return item;
    }

    @Override
    public ArrayList<Item> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from item");
        ArrayList<Item> allItems = new ArrayList<>();
        while (rst.next()) {            
            Item i = new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5), rst.getDouble(6), rst.getInt(7));
            allItems.add(i);
        }
        return allItems;
    }

    @Override
    public boolean updateQty(int orderQty, String item) throws Exception {
        return CrudUtil.executeUpdate("update item set qty=qty-? where itemId=?", orderQty, item);
    }

    @Override
    public String getLastID() throws Exception {
        String sql = "select itemId from item order by itemId desc limit 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        if (rst.next()) {
            String id = rst.getString(1);
            id = id.split("[A-Z]")[1];
            id = (Integer.parseInt(id)+1) + "";
            return "P00" + id;
        } else {
            return "P001";
        }
    }
    
}
