/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.SuperBO;
import lk.ijse.BookShopManagement.Dto.CategoryDTO;

/**
 *
 * @author malsh
 */
public interface CategoryBO extends SuperBO{
    
    public boolean add(CategoryDTO category) throws Exception;
    
    public ArrayList<CategoryDTO> getAllCategories() throws Exception;
    
    public CategoryDTO searchCategory(String id) throws Exception;
    
}
