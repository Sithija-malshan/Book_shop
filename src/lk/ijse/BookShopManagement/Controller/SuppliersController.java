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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.QueryBO;
import lk.ijse.BookShopManagement.Bo.Custom.SupplierBO;
import lk.ijse.BookShopManagement.Dto.SupplierDTO;
import lk.ijse.BookShopManagement.EntityController.SupplierController;

/**
 * FXML Controller class
 *
 * @author malsh
 */
public class SuppliersController implements Initializable {

    @FXML
    private TableView<SupplierDTO> tblSupplier;
    @FXML
    private JFXTextField txtType;
    @FXML
    private ImageView btnReload;
    @FXML
    private ImageView btnSearch;
    @FXML
    private JFXComboBox<String> cmbSearchBy;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnRemove;
    
    private QueryBO queryBO;
    
    private SupplierBO supplierBO;
    
    private String searchByKeyword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        queryBO = (QueryBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.QUERY);
        supplierBO = (SupplierBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIER);
        
        getAllSupplier();
        loadSearchByName();
        
        tblSupplier.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblSupplier.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblSupplier.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblSupplier.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
    }    

    @FXML
    private void searchSupplierKey(KeyEvent event) {
        try {
            String selectedItem = cmbSearchBy.getSelectionModel().getSelectedItem();
            String keyword = txtType.getText();
            ArrayList<SupplierDTO> searchSupplier = supplierBO.getSearchSupplier(selectedItem, keyword);
            tblSupplier.setItems(FXCollections.observableArrayList(searchSupplier));
            
        } catch (Exception ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchSupplier(MouseEvent event) {
    }

    @FXML
    private void selectSupplier(ActionEvent event) {
        searchByKeyword = cmbSearchBy.getValue();
    }

    @FXML
    private void updateSupplier(ActionEvent event) {
    }

    @FXML
    private void removeSupplier(ActionEvent event) {
        SupplierDTO selectedSup = tblSupplier.getSelectionModel().getSelectedItem();
        try {
            boolean delete = new SupplierController().deleteSupplier(selectedSup.getId());
            if (delete) {
                getAllSupplier();
            } else {
            }
        } catch (Exception ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getAllSupplier(){
        try {
            ArrayList<SupplierDTO> allSuppliers = supplierBO.getAllSuppliers();
            tblSupplier.setItems(FXCollections.observableArrayList(allSuppliers));
        } catch (Exception ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadSearchByName(){
        try {
            ArrayList<String> tableColumn = queryBO.getTableColumn("supplier");
            for (String name : tableColumn) {
                cmbSearchBy.getItems().add(name);
            }
        } catch (Exception ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
