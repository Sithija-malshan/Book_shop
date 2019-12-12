/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Dao.CrudUtil;
import lk.ijse.BookShopManagement.Dao.Custom.CustomerOrderDetailDAO;
import lk.ijse.BookShopManagement.Entity.CustomerOrderDetail;

/**
 *
 * @author malsh
 */
public class CustomerOrderDetailDAOImpl implements CustomerOrderDetailDAO{

    @Override
    public boolean add(CustomerOrderDetail t) throws Exception {
        return CrudUtil.executeUpdate("insert into customer_order_detail values(?,?,?,?)", t.getCusOrderId(), t.getItemCode(), t.getQty(), t.getPrice());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CustomerOrderDetail t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerOrderDetail search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CustomerOrderDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
