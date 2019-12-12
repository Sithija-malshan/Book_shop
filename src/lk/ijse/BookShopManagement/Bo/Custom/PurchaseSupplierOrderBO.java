/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom;

import lk.ijse.BookShopManagement.Bo.SuperBO;
import lk.ijse.BookShopManagement.Dto.SupplierOrderDTO;

/**
 *
 * @author malsh
 */
public interface PurchaseSupplierOrderBO extends SuperBO{
    
    public boolean addSupplierOrder(SupplierOrderDTO suppOrder) throws Exception;
    
    public String getLastID() throws Exception;
    
    
}
