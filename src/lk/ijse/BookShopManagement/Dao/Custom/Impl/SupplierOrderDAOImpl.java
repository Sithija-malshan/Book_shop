/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.BookShopManagement.Dao.CrudUtil;
import lk.ijse.BookShopManagement.Dao.Custom.SupplierOrderDAO;
import lk.ijse.BookShopManagement.Entity.SupplierOrder;

/**
 *
 * @author malsh
 */
public class SupplierOrderDAOImpl implements SupplierOrderDAO{

    @Override
    public boolean add(SupplierOrder t) throws Exception {
        return CrudUtil.executeUpdate("insert into supplier_order values(?,?,?)", t.getSoId(), t.getSupId(), t.getDate());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(SupplierOrder t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SupplierOrder search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SupplierOrder> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastID() throws Exception {
        String sql = "select soId from supplier_order order by soId desc limit 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        } else {
            return null;
        }
    }
    
}
