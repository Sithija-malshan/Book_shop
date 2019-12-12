/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Dao.SuperDAO;

/**
 *
 * @author malsh
 */
public interface QueryDAO extends SuperDAO{
    
    public ArrayList<String> getTableColumn(String tableName) throws Exception;
    
}
