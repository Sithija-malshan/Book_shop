/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Controller;

import com.jfoenix.controls.JFXButton;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lk.ijse.BookShopManagement.Db.DBConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author malsh
 */
public class ReportController implements Initializable {

    @FXML
    private JFXButton btnCusReport;
    @FXML
    private JFXButton btnCusOrder;
    @FXML
    private JFXButton btnSupplier;
    @FXML
    private JFXButton btnStock;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void customerReport(ActionEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/BookShopManagement/View/Reports/customers.jasper");
            Connection connection = DBConnection.getInstance().getConnection();
            HashMap map=new HashMap();
            JasperPrint print=JasperFillManager.fillReport(is,map,connection);
            JasperViewer.viewReport(print,false);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cusOrderReport(ActionEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/BookShopManagement/View/Reports/cusOrder.jasper");
            Connection connection = DBConnection.getInstance().getConnection();
            HashMap map=new HashMap();
            JasperPrint print=JasperFillManager.fillReport(is,map,connection);
            JasperViewer.viewReport(print,false);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supplierReport(ActionEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/BookShopManagement/View/Reports/suppliers.jasper");
            Connection connection = DBConnection.getInstance().getConnection();
            HashMap map=new HashMap();
            JasperPrint print=JasperFillManager.fillReport(is,map,connection);
            JasperViewer.viewReport(print,false);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void stockReport(ActionEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/BookShopManagement/View/Reports/stock.jasper");
            Connection connection = DBConnection.getInstance().getConnection();
            HashMap map=new HashMap();
            JasperPrint print=JasperFillManager.fillReport(is,map,connection);
            JasperViewer.viewReport(print,false);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
