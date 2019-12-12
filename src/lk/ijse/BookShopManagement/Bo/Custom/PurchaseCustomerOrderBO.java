/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom;

import lk.ijse.BookShopManagement.Bo.SuperBO;
import lk.ijse.BookShopManagement.Dto.CustomerOrderDTO;

/**
 *
 * @author malsh
 */
public interface PurchaseCustomerOrderBO extends SuperBO{
    public boolean addCustomerOrder(CustomerOrderDTO cusOrder) throws Exception;
}
