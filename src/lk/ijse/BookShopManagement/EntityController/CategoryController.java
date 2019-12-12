/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.EntityController;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.CategoryBO;
import lk.ijse.BookShopManagement.Dto.CategoryDTO;

/**
 *
 * @author malsh
 */
public class CategoryController {
    CategoryBO bO = (CategoryBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CATEGORY);

    public boolean addCategory(CategoryDTO categoryDTO) throws Exception {
        return bO.add(categoryDTO);
    }

    public ArrayList<CategoryDTO> getAllCategory() throws Exception {
        return bO.getAllCategories();
    }
    
    
}
