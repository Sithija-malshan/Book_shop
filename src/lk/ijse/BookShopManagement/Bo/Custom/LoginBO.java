/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom;

import lk.ijse.BookShopManagement.Bo.SuperBO;

/**
 *
 * @author malsh
 */
public interface LoginBO extends SuperBO{
    public String checkPassword(String id)throws Exception;
}
