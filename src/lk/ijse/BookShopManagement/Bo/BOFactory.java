/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo;

import lk.ijse.BookShopManagement.Bo.Custom.Impl.BrandBOImpl;
import lk.ijse.BookShopManagement.Bo.Custom.Impl.CategoryBOImpl;
import lk.ijse.BookShopManagement.Bo.Custom.Impl.CustomerBOImpl;
import lk.ijse.BookShopManagement.Bo.Custom.Impl.ItemBOImpl;
import lk.ijse.BookShopManagement.Bo.Custom.Impl.LoginBOImpl;
import lk.ijse.BookShopManagement.Bo.Custom.Impl.PurchaseCustomerOrderBOImpl;
import lk.ijse.BookShopManagement.Bo.Custom.Impl.PurchaseSupplierOrderBOImpl;
import lk.ijse.BookShopManagement.Bo.Custom.Impl.QueryBOImpl;
import lk.ijse.BookShopManagement.Bo.Custom.Impl.SupplierBOImpl;

/**
 *
 * @author malsh
 */
public class BOFactory {
    private static BOFactory bOFactory;

    public BOFactory() {
    }
    
    public static BOFactory getInstance(){
        if (bOFactory==null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }
    
    public enum BOTypes {
        CUSTOMER, ITEM, PURCHASE_CUS_ORDER, QUERY, SUPPLIER, CATEGORY,
        BRAND, SUPPLIER_ORDER,LOGIN;
    }
    
    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PURCHASE_CUS_ORDER:
                return new PurchaseCustomerOrderBOImpl();
            case QUERY:
                return new QueryBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case CATEGORY:
                return new CategoryBOImpl();
            case BRAND:
                return new BrandBOImpl();
            case SUPPLIER_ORDER:
                return new PurchaseSupplierOrderBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            default:
                return null;
        }
    }
}
