/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lk.ijse.BookShopManagement.Dao.CrudUtil;
import lk.ijse.BookShopManagement.Dao.Custom.LoginDAO;

/**
 *
 * @author malsh
 */
public class LoginDAOImpl implements LoginDAO{

    @Override
    public String checkPassword(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select password from login where userName=?", id);
        String pw = null;  
        if(rst.next()){
                pw = rst.getString(1);
            }
        return pw;
    }
    
    
}
