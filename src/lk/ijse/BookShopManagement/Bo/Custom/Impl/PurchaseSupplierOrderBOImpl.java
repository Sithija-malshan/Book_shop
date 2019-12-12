/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.Custom.PurchaseSupplierOrderBO;
import lk.ijse.BookShopManagement.Dao.Custom.ItemDAO;
import lk.ijse.BookShopManagement.Dao.Custom.SupplierOrderDAO;
import lk.ijse.BookShopManagement.Dao.DAOFactory;
import lk.ijse.BookShopManagement.Db.DBConnection;
import lk.ijse.BookShopManagement.Dto.ItemDTO;
import lk.ijse.BookShopManagement.Dto.SupplierOrderDTO;
import lk.ijse.BookShopManagement.Entity.Item;
import lk.ijse.BookShopManagement.Entity.SupplierOrder;

/**
 *
 * @author malsh
 */
public class PurchaseSupplierOrderBOImpl implements PurchaseSupplierOrderBO{
    SupplierOrderDAO orderDAO = (SupplierOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.SUPPLIER_ORDER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.ITEM);

    @Override
    public boolean addSupplierOrder(SupplierOrderDTO suppOrder) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        
        boolean orderAdded = orderDAO.add(new SupplierOrder(suppOrder.getSoId(), suppOrder.getSupId(), suppOrder.getDate()));
        ArrayList<ItemDTO> orderItems = suppOrder.getOrderItems();
        if (orderAdded) {
            for (ItemDTO i : orderItems) {
                boolean update = itemDAO.update(new Item(i.getItemCode(), i.getDescription(), i.getCategoryID(), i.getBrandID(), i.getCost(), i.getSale(), i.getQty()));
                if (!update) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }
    }

    @Override
    public String getLastID() throws Exception {
        return orderDAO.getLastID();
    }
    
}
