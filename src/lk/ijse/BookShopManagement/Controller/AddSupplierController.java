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
import lk.ijse.BookShopManagement.Bo.Custom.SupplierBO;
import lk.ijse.BookShopManagement.Dto.SupplierDTO;
import lk.ijse.BookShopManagement.EntityController.SupplierController;

/**
 * FXML Controller class
 *
 * @author malsh
 */
public class AddSupplierController implements Initializable {
    
    private SupplierBO supplierBO;

    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private JFXTextField txtId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        supplierBO = (SupplierBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIER);
        loadNextSupplierId();
    }    

    @FXML
    private void clickCancel(ActionEvent event) {
    }

    @FXML
    private void clickSave(ActionEvent event) {
        try {
            String sId = txtId.getText();
            String name = txtName.getText();
            int contact = Integer.parseInt(txtContact.getText());
            String address = txtAddress.getText();
            
            SupplierDTO supplierDTO = new SupplierDTO(sId, name, contact, address);
            boolean addSupplier = new SupplierController().addSupplier(supplierDTO);
            
            if (addSupplier) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added", ButtonType.OK);
                alert.show();
                clear();
                loadNextSupplierId();
                txtName.requestFocus();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Added Fail", ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.setHeaderText("Please try again");
            alert.show();
        }
        
    }
    
    public String getLastId(){
        String lastId = null;
        try {
            String lastID = supplierBO.getLastID();
            if (lastID==null) {
                lastId = "S001";
            } else {
                lastId = lastID;
            }
        } catch (Exception ex) {
            Logger.getLogger(AddItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastId;
    }
    
    private void loadNextSupplierId(){
        String cId = getLastId();
        char ch = cId.charAt(cId.length() - 1);
        int value = Character.getNumericValue(ch);
        cId = cId.substring(0, cId.length() - 1) + value;
        txtId.setText(cId);
    }
    
    private void clear(){
        txtName.setText("");
        txtContact.setText("");
        txtAddress.setText("");
    }

    @FXML
    private void enterName(ActionEvent event) {
        txtContact.requestFocus();
    }

    @FXML
    private void enterAddress(ActionEvent event) {
        clickSave(event);
    }

    @FXML
    private void enterContact(ActionEvent event) {
        txtAddress.requestFocus();
    }
    
}
