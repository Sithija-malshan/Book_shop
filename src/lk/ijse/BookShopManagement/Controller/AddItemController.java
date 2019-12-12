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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.ItemBO;
import lk.ijse.BookShopManagement.Dto.BrandDTO;
import lk.ijse.BookShopManagement.Dto.CategoryDTO;
import lk.ijse.BookShopManagement.Dto.ItemDTO;
import lk.ijse.BookShopManagement.EntityController.BrandController;
import lk.ijse.BookShopManagement.EntityController.CategoryController;
import lk.ijse.BookShopManagement.EntityController.ItemController;

/**
 * FXML Controller class
 *
 * @author malsh
 */
public class AddItemController implements Initializable {
    
    private ItemBO itemBO;

    @FXML
    private JFXTextField txtID;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXComboBox<String> cmbCategory;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXComboBox<String> cmbBrand;
    @FXML
    private JFXTextField txtCostPrice;
    @FXML
    private JFXTextField txtSalePrice;
    @FXML
    private JFXTextField txtQty;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
        loadNextItemId();
        loadAllCategories();
        loadAllBrands();
        txtDescription.requestFocus();
    }    

    @FXML
    private void clickCancel(ActionEvent event) {
    }

    @FXML
    private void clickSave(ActionEvent event) {
        try {
            String id = txtID.getText();
            String description = txtDescription.getText();
            String category = cmbCategory.getValue();
            String brand = cmbBrand.getValue();
            double cost = Double.parseDouble(txtCostPrice.getText());
            double sale = Double.parseDouble(txtSalePrice.getText());
            int qty = Integer.parseInt(txtQty.getText());
            
            ItemDTO itemDTO = new ItemDTO(id, description, category, brand, cost, sale, qty);
            boolean addItem = new ItemController().addItem(itemDTO);
            
            if (addItem) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Item Added", ButtonType.OK);
                alert.show();
                clear();
                txtDescription.requestFocus();
                loadNextItemId();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Item not Added", ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.setHeaderText("Please try again");
            alert.show();
        }
    }
    
    private void loadAllCategories(){
        try {
            ArrayList<CategoryDTO> allCategory = new CategoryController().getAllCategory();
            for (CategoryDTO allcategories : allCategory) {
                cmbCategory.getItems().add(allcategories.getId());
            }
        } catch (Exception ex) {
            Logger.getLogger(AddItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadAllBrands(){
        try {
            ArrayList<BrandDTO> allBrand = new BrandController().getAllCategory();
            for (BrandDTO allBrands : allBrand) {
                cmbBrand.getItems().add(allBrands.getId());
            }
        } catch (Exception ex) {
            Logger.getLogger(AddItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void clear(){
        txtID.setText("");
        txtDescription.setText("");
        txtCostPrice.setText("");
        txtSalePrice.setText("");
        txtQty.setText("");
    }
    
    public String getLastId(){
        String lastId = null;
        try {
            String lastID = itemBO.getLastID();
            if (lastID==null) {
                lastId = "P001";
            } else {
                lastId = lastID;
            }
        } catch (Exception ex) {
            Logger.getLogger(AddItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastId;
    }
    
    private void loadNextItemId(){
        String cId = getLastId();
        char ch = cId.charAt(cId.length() - 1);
        int value = Character.getNumericValue(ch);
        cId = cId.substring(0, cId.length() - 1) + value;
        txtID.setText(cId);
    }

    @FXML
    private void enterCostPrice(ActionEvent event) {
        txtSalePrice.requestFocus();
    }

    @FXML
    private void enterSalePrice(ActionEvent event) {
        txtQty.requestFocus();
    }

    @FXML
    private void enterQty(ActionEvent event) {
        clickSave(event);
    }
    
}
