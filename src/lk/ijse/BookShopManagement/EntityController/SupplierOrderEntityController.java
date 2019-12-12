/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.EntityController;

import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.PurchaseSupplierOrderBO;
import lk.ijse.BookShopManagement.Dto.SupplierOrderDTO;

/**
 *
 * @author malsh
 */
public class SupplierOrderEntityController {
    PurchaseSupplierOrderBO orderBO = (PurchaseSupplierOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIER_ORDER);

    public boolean addOrder(SupplierOrderDTO sodto) throws Exception {
        return orderBO.addSupplierOrder(sodto);
    }
    
}
