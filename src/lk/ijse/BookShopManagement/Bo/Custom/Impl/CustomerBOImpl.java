/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.Custom.CustomerBO;
import lk.ijse.BookShopManagement.Dao.Custom.CustomerDAO;
import lk.ijse.BookShopManagement.Dao.DAOFactory;
import lk.ijse.BookShopManagement.Dto.CustomerDTO;
import lk.ijse.BookShopManagement.Entity.Customer;

/**
 *
 * @author malsh
 */
public class CustomerBOImpl implements CustomerBO{
    
    CustomerDAO dAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
        return dAO.add(new Customer(customer.getCusId(), customer.getName(), customer.getContact(), customer.getAddress()));
    }

    @Override
    public boolean deleteCustomer(String customerID) throws Exception {
        return dAO.delete(customerID);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        return dAO.update(new Customer(customer.getCusId(), customer.getName(), customer.getContact(), customer.getAddress()));
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        Customer c = dAO.search(id);
        return new CustomerDTO(c.getCusId(), c.getName(), c.getContact(), c.getAddress());
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        ArrayList<Customer> all = dAO.getAll();
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        for (Customer c : all) {
            allCustomers.add(new CustomerDTO(c.getCusId(), c.getName(), c.getContact(), c.getAddress()));
        }
        return allCustomers;
    }

    @Override
    public String getLastID() throws Exception {
        return dAO.getLastID();
    }

    @Override
    public CustomerDTO searchContact(String contact) throws Exception {
        Customer c = dAO.searchContact(contact);
        return new CustomerDTO(c.getCusId(), c.getName(), c.getContact(), c.getAddress());
    }

    @Override
    public ArrayList<CustomerDTO> getSearchCustomer(String field, String keyword) throws Exception {
        ArrayList<Customer> searchCustomer = dAO.getSearchCustomer(field, keyword);
        ArrayList<CustomerDTO> customerDTOs = new ArrayList<>();
        for (Customer c : searchCustomer) {
            customerDTOs.add(new CustomerDTO(c.getCusId(), c.getName(), c.getContact(), c.getAddress()));
        }
        return customerDTOs;
    }
    
}
