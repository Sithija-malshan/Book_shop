/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.SuperBO;
import lk.ijse.BookShopManagement.Dto.SupplierDTO;

/**
 *
 * @author malsh
 */
public interface SupplierBO extends SuperBO {
    
    public boolean addSupplier(SupplierDTO supplier) throws Exception;
    
    public boolean deleteSupplier(String supplierId) throws Exception;
    
    public boolean updateSupplier(SupplierDTO supplier) throws Exception;
    
    public SupplierDTO searchSupplier(String id) throws Exception;
    
    public ArrayList<SupplierDTO> getAllSuppliers() throws Exception;
    
    public ArrayList<SupplierDTO> getSearchSupplier(String field, String keyword) throws Exception;
    
    public String getLastID() throws Exception;
    
}
