/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author malsh
 */
public class UpdateItemController implements Initializable {

    @FXML
    private JFXTextField txtID;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXComboBox<?> cmbCategory;
    @FXML
    private JFXComboBox<?> cmbBrand;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXButton btnUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancelUpdate(ActionEvent event) {
    }

    @FXML
    private void updateItem(ActionEvent event) {
    }
    
}
