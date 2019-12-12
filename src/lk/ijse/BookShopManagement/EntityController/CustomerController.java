/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.EntityController;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.CustomerBO;
import lk.ijse.BookShopManagement.Dto.CustomerDTO;

/**
 *
 * @author malsh
 */
public class CustomerController {
    CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        return customerBO.addCustomer(customerDTO);
    }
    
    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        return customerBO.getAllCustomers();
    }
    
    public CustomerDTO searchCustomer(String id) throws Exception {
        return customerBO.searchCustomer(id);
    }
    
    public CustomerDTO searchContact(String contact) throws Exception {
        return customerBO.searchContact(contact);
    }

    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        return customerBO.updateCustomer(customer);
    }

    public boolean deleteCustomer(String cusId) throws Exception {
        return customerBO.deleteCustomer(cusId);
    }
}
