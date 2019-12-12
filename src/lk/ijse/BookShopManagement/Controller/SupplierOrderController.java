/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.PurchaseSupplierOrderBO;
import lk.ijse.BookShopManagement.Dto.BrandDTO;
import lk.ijse.BookShopManagement.Dto.CategoryDTO;
import lk.ijse.BookShopManagement.Dto.ItemDTO;
import lk.ijse.BookShopManagement.Dto.SupplierDTO;
import lk.ijse.BookShopManagement.Dto.SupplierOrderDTO;
import lk.ijse.BookShopManagement.EntityController.BrandController;
import lk.ijse.BookShopManagement.EntityController.CategoryController;
import lk.ijse.BookShopManagement.EntityController.ItemController;
import lk.ijse.BookShopManagement.EntityController.SupplierController;
import lk.ijse.BookShopManagement.EntityController.SupplierOrderEntityController;

/**
 * FXML Controller class
 *
 * @author malsh
 */
public class SupplierOrderController implements Initializable {

    @FXML
    private Label lblDate;
    @FXML
    private JFXButton placeOrderBtn;
    @FXML
    private Label lblOrderId;
    @FXML
    private JFXButton btnNewSup;
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXComboBox<String> cmbSelectSup;
    @FXML
    private Label lblName;
    @FXML
    private Label lblContact;
    @FXML
    private JFXTextField txtSearchItem;
    @FXML
    private JFXComboBox<String> cmbSelectItem;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXTextField txtCostPrice;
    @FXML
    private JFXTextField txtSalePrice;
    
    private PurchaseSupplierOrderBO psobo;
    @FXML
    private JFXComboBox<String> cmbCategory;
    @FXML
    private JFXComboBox<String> cmbBrand;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        psobo = (PurchaseSupplierOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIER_ORDER);
        loadOd();
        loadDate();
        loadAllSuppliers();
        loadAllItems();
        loadAllCategories();
        loadAllBrands();
        
    }    
    private void loadDate(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e ->{
            lblDate.setText(LocalDate.now().toString());
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void clickPlaceOrder(ActionEvent event) {
        try {
            String odId = lblOrderId.getText();
            String supId = cmbSelectSup.getValue();
            String date = lblDate.getText();
            String itemId = txtSearchItem.getText();
            String descrip = txtDescription.getText();
            String ctId = cmbCategory.getValue();
            String brId = cmbBrand.getValue();
            double cost = Double.parseDouble(txtCostPrice.getText());
            double sale = Double.parseDouble(txtSalePrice.getText());
            int qty = Integer.parseInt(txtQty.getText());
            
            ArrayList<ItemDTO> items = new ArrayList<>();
            ItemDTO item = new ItemDTO(itemId, descrip, ctId, brId, cost, sale, qty);
            items.add(item);
            SupplierOrderDTO sodto = new SupplierOrderDTO(odId, supId, date, items);
            boolean addOrder = psobo.addSupplierOrder(sodto);
            if (addOrder) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Order Added", ButtonType.OK);
                alert.show();
                loadOd();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Added Fail", ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.setHeaderText("Something went wrong");
            alert.show();
        }
        
    }

    @FXML
    private void addNewSupplier(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/BookShopManagement/View/addSupplier.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void clearAll(ActionEvent event) {
    }
    
    private void loadAllSuppliers(){
        try {
            ArrayList<SupplierDTO> allSuppliers = new SupplierController().getAllSuppliers();
            for (SupplierDTO allSupplier : allSuppliers) {
                cmbSelectSup.getItems().add(allSupplier.getId());
            }
        } catch (Exception ex) {
            Logger.getLogger(SupplierOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void selectSupplier(ActionEvent event) {
        try {
            String supId = cmbSelectSup.getValue();
            SupplierDTO supplier = new SupplierController().searchSupplier(supId);
            lblName.setText(supplier.getName());
            lblContact.setText(supplier.getContact() + "");
        } catch (Exception ex) {
            Logger.getLogger(SupplierOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void selectItem(ActionEvent event) {
        try {
            String ct = cmbSelectItem.getValue();
            ItemDTO searchItem = new ItemController().searchItem(ct);
            String itemCode = cmbSelectItem.getValue();
            ItemDTO item = new ItemController().searchItem(itemCode);
            txtSearchItem.setText(item.getItemCode());
            txtDescription.setText(item.getDescription());
            cmbCategory.getSelectionModel().select(searchItem.getCategoryID());
            cmbBrand.getSelectionModel().select(searchItem.getBrandID());
            
            
        } catch (Exception ex) {
            Logger.getLogger(SupplierOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void loadAllItems(){
        try {
            ArrayList<ItemDTO> allItems = new ItemController().getAllItem();
            for (ItemDTO allItem : allItems) {
                cmbSelectItem.getItems().add(allItem.getItemCode());
            }
        } catch (Exception ex) {
            Logger.getLogger(SupplierOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void enterQty(ActionEvent event) {
        
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
    private void loadOd(){
        int i = new Random().nextInt(900);
        lblOrderId.setText("D"+i);
    }
}
