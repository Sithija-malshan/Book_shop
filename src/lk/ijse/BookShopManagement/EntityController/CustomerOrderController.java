/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.EntityController;

import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.PurchaseCustomerOrderBO;
import lk.ijse.BookShopManagement.Dto.CustomerOrderDTO;

/**
 *
 * @author malsh
 */
public class CustomerOrderController {
    
    PurchaseCustomerOrderBO bO = (PurchaseCustomerOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PURCHASE_CUS_ORDER);
    
    public boolean addCusOrder(CustomerOrderDTO dto) throws Exception {
        return bO.addCustomerOrder(dto);
    }
}
