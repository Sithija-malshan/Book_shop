/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.EntityController;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.ItemBO;
import lk.ijse.BookShopManagement.Dto.ItemDTO;

/**
 *
 * @author malsh
 */
public class ItemController {
    
    ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
    
    public boolean addItem(ItemDTO itemDTO) throws Exception {
        return itemBO.addItem(itemDTO);
    }
    
    public ArrayList<ItemDTO> getAllItem() throws Exception {
        return itemBO.getAllItems();
    }
    
    public ItemDTO searchItem(String code) throws Exception {
        return itemBO.searchItem(code);
    }

    public boolean deleteItem(String itemCode) throws Exception {
        return itemBO.deleteItem(itemCode);
    }
}
