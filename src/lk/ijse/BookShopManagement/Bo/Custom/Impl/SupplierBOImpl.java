/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.Custom.SupplierBO;
import lk.ijse.BookShopManagement.Dao.Custom.SupplierDAO;
import lk.ijse.BookShopManagement.Dao.DAOFactory;
import lk.ijse.BookShopManagement.Dto.SupplierDTO;
import lk.ijse.BookShopManagement.Entity.Supplier;

/**
 *
 * @author malsh
 */
public class SupplierBOImpl implements SupplierBO{
    SupplierDAO dAO = (SupplierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.SUPPLIER);

    @Override
    public boolean addSupplier(SupplierDTO supplier) throws Exception {
        return dAO.add(new Supplier(supplier.getId(), supplier.getName(), supplier.getContact(), supplier.getAddress()));
    }

    @Override
    public boolean deleteSupplier(String supplierId) throws Exception {
        return dAO.delete(supplierId);
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplier) throws Exception {
        return dAO.update(new Supplier(supplier.getId(), supplier.getName(), supplier.getContact(), supplier.getAddress()));
    }

    @Override
    public SupplierDTO searchSupplier(String id) throws Exception {
        Supplier s = dAO.search(id);
        return new SupplierDTO(s.getId(), s.getName(), s.getContact(), s.getAddress());
    }

    @Override
    public ArrayList<SupplierDTO> getAllSuppliers() throws Exception {
        ArrayList<Supplier> all = dAO.getAll();
        ArrayList<SupplierDTO> allSuppliers = new ArrayList<>();
        for (Supplier s : all) {
            allSuppliers.add(new SupplierDTO(s.getId(), s.getName(), s.getContact(), s.getAddress()));
        }
        return allSuppliers;
    }

    @Override
    public ArrayList<SupplierDTO> getSearchSupplier(String field, String keyword) throws Exception {
        ArrayList<Supplier> searchSuppier = dAO.getSearchSupplier(field, keyword);
        ArrayList<SupplierDTO> supplier = new ArrayList<>();
        for (Supplier s : searchSuppier) {
            supplier.add(new SupplierDTO(s.getId(), s.getName(), s.getContact(), s.getAddress()));
        }
        return supplier;
    }

    @Override
    public String getLastID() throws Exception {
        return dAO.getLastID();
    }
    
}
