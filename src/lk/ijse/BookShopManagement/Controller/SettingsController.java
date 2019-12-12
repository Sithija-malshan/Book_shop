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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import lk.ijse.BookShopManagement.Dto.BrandDTO;
import lk.ijse.BookShopManagement.Dto.CategoryDTO;
import lk.ijse.BookShopManagement.EntityController.BrandController;
import lk.ijse.BookShopManagement.EntityController.CategoryController;

/**
 * FXML Controller class
 *
 * @author malsh
 */
public class SettingsController implements Initializable {

    @FXML
    private JFXTextField txtCatId;
    @FXML
    private JFXTextField txtCatName;
    @FXML
    private JFXTextField txtBrandId;
    @FXML
    private JFXTextField txtBrandName;
    @FXML
    private JFXButton btnAddCat;
    @FXML
    private JFXButton btnAddBrand;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void addNewCategoey(ActionEvent event) {
        try {
            String cid = txtCatId.getText();
            String cName = txtCatName.getText();
            
            CategoryDTO categoryDTO = new CategoryDTO(cid, cName);
            boolean addCategory = new CategoryController().addCategory(categoryDTO);
            
            if (addCategory) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Catogory Added", ButtonType.OK);
                alert.show();
                clearCategory();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Pleace try again", ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Category ID can't duplicate", ButtonType.CLOSE);
            alert.setHeaderText("Duplicate Entry Found");
            alert.setTitle("Duplicate Error");
            alert.show();
        }
        
    }

    @FXML
    private void addNewBrand(ActionEvent event) {
        try {
            String bId = txtBrandId.getText();
            String bName = txtBrandName.getText();
            
            BrandDTO brandDTO = new BrandDTO(bId, bName);
            boolean addBrand = new BrandController().addBrand(brandDTO);
            
            if (addBrand) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Brand Added", ButtonType.OK);
                alert.show();
                clearBrand();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Pleace try again", ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Brand ID can't duplicate", ButtonType.CLOSE);
            alert.setHeaderText("Duplicate Entry Found");
            alert.setTitle("Duplicate Error");
            alert.show();
        }
        
        
    }

    @FXML
    private void enterCatName(ActionEvent event) {
        btnAddCat.requestFocus();
    }

    @FXML
    private void enterBrandName(ActionEvent event) {
        btnAddBrand.requestFocus();
    }
    
    private void clearCategory(){
        txtCatId.setText("");
        txtCatName.setText("");
    }
    
    private void clearBrand(){
        txtBrandId.setText("");
        txtBrandName.setText("");
    }

}
