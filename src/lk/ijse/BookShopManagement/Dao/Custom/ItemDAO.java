/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom;

import lk.ijse.BookShopManagement.Dao.CrudDAO;
import lk.ijse.BookShopManagement.Entity.Item;

/**
 *
 * @author malsh
 */
public interface ItemDAO extends CrudDAO<Item, String>{
    
    public boolean updateQty(int orderQty, String item) throws Exception;
    
    public String getLastID() throws Exception;
    
}
