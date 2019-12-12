/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.SuperBO;

/**
 *
 * @author malsh
 */
public interface QueryBO extends SuperBO{
    
    public ArrayList<String> getTableColumn(String tableName) throws Exception;
    
}
