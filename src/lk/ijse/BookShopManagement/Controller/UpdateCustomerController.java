/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import lk.ijse.BookShopManagement.Dto.CustomerDTO;
import lk.ijse.BookShopManagement.EntityController.CustomerController;

/**
 * FXML Controller class
 *
 * @author malsh
 */
public class UpdateCustomerController implements Initializable {

    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtMobile;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXTextField txtCusId;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void clickCancel(ActionEvent event) {
    }

    @FXML
    private void clickUpdate(ActionEvent event) {
        
        String cusId = CustomersController.cusId;
        String name = CustomersController.name;
        int contact = CustomersController.contact;
        String address = CustomersController.address;
        
        txtCusId.setText(cusId);
        txtName.setText(name);
        txtMobile.setText(contact+"");
        txtAddress.setText(address);
        
        CustomerDTO customer = new CustomerDTO(cusId, name, contact, address);
        try {
            boolean updateCustomer = new CustomerController().updateCustomer(customer);
            if (updateCustomer) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated", ButtonType.OK);
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Update Fail", ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(UpdateCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
