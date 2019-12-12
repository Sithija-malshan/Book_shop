/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.BookShopManagement.Dao.CrudUtil;
import lk.ijse.BookShopManagement.Dao.Custom.CustomerDAO;
import lk.ijse.BookShopManagement.Entity.Customer;

/**
 *
 * @author malsh
 */
public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public boolean add(Customer t) throws Exception {
        return CrudUtil.executeUpdate("insert into customer values(?,?,?,?)", t.getCusId(), t.getName(), t.getContact(), t.getAddress());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from customer where cusID=?", id);
    }

    @Override
    public boolean update(Customer t) throws Exception {
        return CrudUtil.executeUpdate("update customer set name=?,contact=?,address=? where cusID=?", t.getName(), t.getContact(), t.getAddress(), t.getCusId());
    }

    @Override
    public Customer search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from customer where cusID=?", id);
        Customer customer = null;
        while (rst.next()) {
            customer = new Customer(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4));
        }
        return customer;
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from customer");
        ArrayList<Customer> allCustomers= new ArrayList<>();
        while (rst.next()) {
            Customer c = new Customer(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4));
            allCustomers.add(c);
        }
        return allCustomers;
    }

    @Override
    public String getLastID() throws Exception {
        String sql = "select cusID from customer order by cusID desc limit 1";
        ResultSet executeQuery = CrudUtil.executeQuery(sql);
        if (executeQuery.next()) {
            String cusId = executeQuery.getString(1);
            cusId = cusId.split("[A-Z]")[1];
            cusId = (Integer.parseInt(cusId)+1) + "";
            return "C00" + cusId;
        }else {
            return "C001";
        }
    }

    @Override
    public ArrayList<Customer> getSearchCustomer(String field, String keyword) throws Exception {
        String sql = "select * from customer where name like ? ";
        String key = "%"+keyword+"%";
        ResultSet rst = CrudUtil.executeQuery(sql, key);
        ArrayList<Customer> customers = new ArrayList<>();
        while (rst.next()) {            
            customers.add(new Customer(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4)));
            
        }
        return customers;
    }

    @Override
    public Customer searchContact(String contact) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from customer where contact=?", contact);
        Customer customer = null;
        while (rst.next()) {            
            customer = new Customer(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4));
        }
        return customer;
    }
    
}
