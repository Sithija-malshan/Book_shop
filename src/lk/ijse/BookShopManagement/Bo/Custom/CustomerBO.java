/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.SuperBO;
import lk.ijse.BookShopManagement.Dto.CustomerDTO;

/**
 *
 * @author malsh
 */
public interface CustomerBO extends SuperBO{
    
    public boolean addCustomer(CustomerDTO customer) throws Exception;
    
    public boolean deleteCustomer(String customerID) throws Exception;
    
    public boolean updateCustomer(CustomerDTO customer) throws Exception;
    
    public CustomerDTO searchCustomer(String id) throws Exception;
    
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception;
    
    public String getLastID() throws Exception;
    
    public CustomerDTO searchContact(String contact) throws Exception;
    
    public ArrayList<CustomerDTO> getSearchCustomer(String field, String keyword) throws Exception;
}
