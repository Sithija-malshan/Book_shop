/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Dao.CrudDAO;
import lk.ijse.BookShopManagement.Entity.Customer;

/**
 *
 * @author malsh
 */
public interface CustomerDAO extends CrudDAO<Customer, String>{
    
    public String getLastID() throws Exception;
    
    public ArrayList<Customer> getSearchCustomer(String field, String keyword) throws Exception;
    
    public Customer searchContact(String contact) throws Exception;
}
