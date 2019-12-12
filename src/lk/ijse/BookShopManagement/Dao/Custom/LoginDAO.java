/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dao.Custom;

import lk.ijse.BookShopManagement.Dao.SuperDAO;

/**
 *
 * @author malsh
 */
public interface LoginDAO extends SuperDAO{
    public String checkPassword(String id)throws Exception;
}
