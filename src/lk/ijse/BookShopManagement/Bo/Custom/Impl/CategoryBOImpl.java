/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.Custom.CategoryBO;
import lk.ijse.BookShopManagement.Dao.Custom.CategoryDAO;
import lk.ijse.BookShopManagement.Dao.DAOFactory;
import lk.ijse.BookShopManagement.Dto.CategoryDTO;
import lk.ijse.BookShopManagement.Entity.Category;

/**
 *
 * @author malsh
 */
public class CategoryBOImpl implements CategoryBO{
    CategoryDAO dAO = (CategoryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.CATEGORY);

    @Override
    public boolean add(CategoryDTO category) throws Exception {
        return dAO.add(new Category(category.getId(), category.getName()));
    }

    @Override
    public ArrayList<CategoryDTO> getAllCategories() throws Exception {
        ArrayList<Category> all = dAO.getAll();
        ArrayList<CategoryDTO> allCategory = new ArrayList<>();
        for (Category c : all) {
            allCategory.add(new CategoryDTO(c.getId(), c.getName()));
        }
        return allCategory;
    }

    @Override
    public CategoryDTO searchCategory(String id) throws Exception {
        Category s = dAO.search(id);
        return new CategoryDTO(s.getId(), s.getName());
    }
    
}
