/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.EntityController;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.BrandBO;
import lk.ijse.BookShopManagement.Dto.BrandDTO;

/**
 *
 * @author malsh
 */
public class BrandController {
    BrandBO brandBO = (BrandBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BRAND);

    public boolean addBrand(BrandDTO brandDTO) throws Exception {
        return brandBO.add(brandDTO);
    }

    public ArrayList<BrandDTO> getAllCategory() throws Exception {
        return brandBO.getAllBrands();
    }
    
    
}
