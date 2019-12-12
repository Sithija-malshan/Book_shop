/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.Custom.PurchaseCustomerOrderBO;
import lk.ijse.BookShopManagement.Dao.Custom.CustomerOrderDAO;
import lk.ijse.BookShopManagement.Dao.Custom.CustomerOrderDetailDAO;
import lk.ijse.BookShopManagement.Dao.Custom.ItemDAO;
import lk.ijse.BookShopManagement.Dao.DAOFactory;
import lk.ijse.BookShopManagement.Db.DBConnection;
import lk.ijse.BookShopManagement.Dto.CustomerOrderDTO;
import lk.ijse.BookShopManagement.Dto.CustomerOrderDetailDTO;
import lk.ijse.BookShopManagement.Dto.ItemDTO;
import lk.ijse.BookShopManagement.Entity.CustomerOrder;
import lk.ijse.BookShopManagement.Entity.CustomerOrderDetail;

/**
 *
 * @author malsh
 */
public class PurchaseCustomerOrderBOImpl implements PurchaseCustomerOrderBO{
    CustomerOrderDAO orderDAO = (CustomerOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.CUSTOMER_ORDER);
    CustomerOrderDetailDAO orderDetailDAO = (CustomerOrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.CUSTOMER_ORDER_DETAIL);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.ITEM);
    
    @Override
    public boolean addCustomerOrder(CustomerOrderDTO cusOrder) throws Exception {
        
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean orderAded = orderDAO.add(new CustomerOrder(cusOrder.getOrderId(), cusOrder.getCusId(), cusOrder.getDate(), cusOrder.getTotal()));
        
        ArrayList<CustomerOrderDetailDTO> allOrderDetails = cusOrder.getAllOrderDetails();
        if (orderAded) {
            for (CustomerOrderDetailDTO o : allOrderDetails) {
                boolean add = orderDetailDAO.add(new CustomerOrderDetail(o.getOrderId(), o.getItemCode(), o.getQty(), o.getPrice()));
                ArrayList<ItemDTO> orderItem = cusOrder.getOrderItem();
                for (ItemDTO i : orderItem) {
                        boolean update = itemDAO.updateQty(i.getQty(), i.getItemCode());
                    if (!add) {
                        if (!update) {
                            connection.rollback();
                            connection.setAutoCommit(true);
                            return false;
                        }
                    }
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
    
}
