/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao;

import lk.ijse.BookShopManagement.Dao.Custom.Impl.BrandDAOImpl;
import lk.ijse.BookShopManagement.Dao.Custom.Impl.CategoryDAOImpl;
import lk.ijse.BookShopManagement.Dao.Custom.Impl.CustomerDAOImpl;
import lk.ijse.BookShopManagement.Dao.Custom.Impl.CustomerOrderDAOImpl;
import lk.ijse.BookShopManagement.Dao.Custom.Impl.CustomerOrderDetailDAOImpl;
import lk.ijse.BookShopManagement.Dao.Custom.Impl.ItemDAOImpl;
import lk.ijse.BookShopManagement.Dao.Custom.Impl.LoginDAOImpl;
import lk.ijse.BookShopManagement.Dao.Custom.Impl.QueryDAOImpl;
import lk.ijse.BookShopManagement.Dao.Custom.Impl.SupplierDAOImpl;
import lk.ijse.BookShopManagement.Dao.Custom.Impl.SupplierOrderDAOImpl;

/**
 *
 * @author malsh
 */
public class DAOFactory {
    private static DAOFactory dAOFactory;

    private DAOFactory() {
    }
    
    public static DAOFactory getInstance(){
        if (dAOFactory==null) {
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }
    
    public enum DAOFactoryTypes {
        CUSTOMER, ITEM, CUSTOMER_ORDER, CUSTOMER_ORDER_DETAIL, QUERY, SUPPLIER,
        CATEGORY, BRAND, SUPPLIER_ORDER,LOGIN;
    }
    
    public SuperDAO getDAO(DAOFactoryTypes types) {
        switch(types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case CUSTOMER_ORDER:
                return new CustomerOrderDAOImpl();
            case CUSTOMER_ORDER_DETAIL:
                return new CustomerOrderDetailDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case CATEGORY:
                return new CategoryDAOImpl();
            case BRAND:
                return new BrandDAOImpl();
            case SUPPLIER_ORDER:
                return new SupplierOrderDAOImpl();
            case LOGIN:
                return new LoginDAOImpl();
            default:
                return null;
        }
    }
}
