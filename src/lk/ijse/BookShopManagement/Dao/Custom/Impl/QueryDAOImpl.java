/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.BookShopManagement.Dao.CrudUtil;
import lk.ijse.BookShopManagement.Dao.Custom.QueryDAO;

/**
 *
 * @author malsh
 */
public class QueryDAOImpl implements QueryDAO{

    @Override
    public ArrayList<String> getTableColumn(String tableName) throws Exception {
        String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'bookshop' AND TABLE_NAME = ?";
        ResultSet rst = CrudUtil.executeQuery(sql, tableName);
        ArrayList<String> columName = new ArrayList<>();
        while (rst.next()) {            
            columName.add(rst.getString(1));
        }
        return columName;
    }
    
}
