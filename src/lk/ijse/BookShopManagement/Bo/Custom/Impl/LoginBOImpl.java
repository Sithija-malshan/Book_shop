/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom.Impl;

import lk.ijse.BookShopManagement.Bo.Custom.LoginBO;
import lk.ijse.BookShopManagement.Dao.Custom.LoginDAO;
import lk.ijse.BookShopManagement.Dao.DAOFactory;

/**
 *
 * @author malsh
 */
public class LoginBOImpl implements LoginBO{
    LoginDAO  loginDAO;
    public LoginBOImpl() {
        loginDAO=(LoginDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.LOGIN);
    }

    
    @Override
    public String checkPassword(String id) throws Exception {
        return loginDAO.checkPassword(id);
    }
    
}
