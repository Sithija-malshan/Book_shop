/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Bo.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.BookShopManagement.Bo.Custom.QueryBO;
import lk.ijse.BookShopManagement.Dao.Custom.QueryDAO;
import lk.ijse.BookShopManagement.Dao.DAOFactory;

/**
 *
 * @author malsh
 */
public class QueryBOImpl implements QueryBO{
    
    QueryDAO dAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.QUERY);

    @Override
    public ArrayList<String> getTableColumn(String tableName) throws Exception {
        return dAO.getTableColumn(tableName);
    }
    
}
