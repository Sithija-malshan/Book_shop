/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.EntityController;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.SupplierBO;
import lk.ijse.BookShopManagement.Dto.SupplierDTO;

/**
 *
 * @author malsh
 */
public class SupplierController {
    SupplierBO supplierBO = (SupplierBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIER);

    public boolean addSupplier(SupplierDTO supplierDTO) throws Exception{
        return supplierBO.addSupplier(supplierDTO);
    }

    public ArrayList<SupplierDTO> getAllSuppliers() throws Exception {
        return supplierBO.getAllSuppliers();
    }

    public SupplierDTO searchSupplier(String supId) throws Exception {
        return supplierBO.searchSupplier(supId);
    }

    public boolean deleteSupplier(String id) throws Exception {
        return supplierBO.deleteSupplier(id);
    }

}
