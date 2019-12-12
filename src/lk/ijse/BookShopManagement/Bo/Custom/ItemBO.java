/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.SuperBO;
import lk.ijse.BookShopManagement.Dto.ItemDTO;

/**
 *
 * @author malsh
 */
public interface ItemBO extends SuperBO{
    
    public boolean addItem(ItemDTO item) throws Exception;
    
    public boolean deleteItem(String code) throws Exception;
    
    public boolean updateItem(ItemDTO item) throws Exception;
    
    public ItemDTO searchItem(String code) throws Exception;
    
    public ArrayList<ItemDTO> getAllItems() throws Exception;
    
    public boolean updateQty(int orderQty, String item) throws Exception;
    
    public String getLastID() throws Exception;
    
}
