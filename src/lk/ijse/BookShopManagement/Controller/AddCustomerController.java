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
import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.CustomerBO;
import lk.ijse.BookShopManagement.Dto.CustomerDTO;
import lk.ijse.BookShopManagement.EntityController.CustomerController;

/**
 * FXML Controller class
 *
 * @author malsh
 */
public class AddCustomerController implements Initializable {

    private CustomerBO customerBO;
    
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtMobile;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXTextField txtCusId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
        loadNextCusId();
    }    

    @FXML
    private void clickCancel(ActionEvent event) {
    }

    @FXML
    private void clickSave(ActionEvent event) {
        try {
            String cId = txtCusId.getText();
            String name = txtName.getText();
            int contact = Integer.parseInt(txtMobile.getText());
            String address = txtAddress.getText();
            
            CustomerDTO customerDTO = new CustomerDTO(cId, name, contact, address);
            boolean addCustomer = new CustomerController().addCustomer(customerDTO);
            
            if(addCustomer){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added", ButtonType.OK);
                alert.show();
                clear();
                txtName.requestFocus();
                loadNextCusId();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Added Fail", ButtonType.CLOSE);
                alert.show();
            }
            
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.setHeaderText("Please try again");
            alert.show();
        }
    }
    
    
    
    public String getLastID(){
        String lastId = null;
        try {   
            String lastId1 = customerBO.getLastID();
            if (lastId1==null) {
                lastId = "C001";
            } else {
                lastId = lastId1;
            }
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastId;
    }
    
    private void loadNextCusId(){
        String cId = getLastID();
        char ch = cId.charAt(cId.length() - 1);
        int value = Character.getNumericValue(ch);
        cId = cId.substring(0, cId.length() - 1) + value;
        txtCusId.setText(cId);
    }
    
    private void clear(){
        txtName.setText("");
        txtMobile.setText("");
        txtAddress.setText("");
    }

    @FXML
    private void enterName(ActionEvent event) {
        txtMobile.requestFocus();
    }

    @FXML
    private void enterContact(ActionEvent event) {
        txtAddress.requestFocus();
    }

    @FXML
    private void enterAddress(ActionEvent event) {
        clickSave(event);
    }
}
