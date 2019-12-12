/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom;

import lk.ijse.BookShopManagement.Dao.CrudDAO;
import lk.ijse.BookShopManagement.Entity.SupplierOrder;

/**
 *
 * @author malsh
 */
public interface SupplierOrderDAO extends CrudDAO<SupplierOrder, String>{
    
    public String getLastID() throws Exception;
    
}
