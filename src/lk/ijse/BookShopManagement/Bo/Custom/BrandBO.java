/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.SuperBO;
import lk.ijse.BookShopManagement.Dto.BrandDTO;

/**
 *
 * @author malsh
 */
public interface BrandBO extends SuperBO{
    
    public boolean add(BrandDTO brand) throws Exception;
    
    public ArrayList<BrandDTO> getAllBrands() throws Exception;
    
    public BrandDTO searchBrand(String id) throws Exception;
    
}
