/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.Custom.ItemBO;
import lk.ijse.BookShopManagement.Dao.Custom.ItemDAO;
import lk.ijse.BookShopManagement.Dao.DAOFactory;
import lk.ijse.BookShopManagement.Dto.ItemDTO;
import lk.ijse.BookShopManagement.Entity.Item;

/**
 *
 * @author malsh
 */
public class ItemBOImpl implements ItemBO{
    
    ItemDAO dAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.ITEM);

    @Override
    public boolean addItem(ItemDTO item) throws Exception {
        return  dAO.add(new Item(item.getItemCode(), item.getDescription(), item.getCategoryID(), item.getBrandID(), item.getCost(), item.getSale(), item.getQty()));
    }

    @Override
    public boolean deleteItem(String code) throws Exception {
        return dAO.delete(code);
    }

    @Override
    public boolean updateItem(ItemDTO item) throws Exception {
        return dAO.update(new Item(item.getItemCode(), item.getDescription(), item.getCategoryID(), item.getBrandID(), item.getCost(), item.getSale(), item.getQty()));
    }

    @Override
    public ItemDTO searchItem(String code) throws Exception {
        Item i = dAO.search(code);
        return new ItemDTO(i.getItemCode(), i.getDescription(), i.getCategoryID(), i.getBrandID(), i.getCost(), i.getSale(), i.getQty());
        
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws Exception {
        ArrayList<Item> all = dAO.getAll();
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        for (Item i : all) {
            allItems.add(new ItemDTO(i.getItemCode(), i.getDescription(), i.getCategoryID(), i.getBrandID(), i.getCost(), i.getSale(), i.getQty()));
        }
        return allItems;
    }

    @Override
    public boolean updateQty(int orderQty, String item) throws Exception {
        return dAO.updateQty(orderQty, item);
    }

    @Override
    public String getLastID() throws Exception {
        return dAO.getLastID();
    }
    
}
