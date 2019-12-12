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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.ItemBO;
import lk.ijse.BookShopManagement.Bo.Custom.QueryBO;
import lk.ijse.BookShopManagement.Dto.ItemDTO;
import lk.ijse.BookShopManagement.EntityController.ItemController;

/**
 * FXML Controller class
 *
 * @author malsh
 */
public class StockController implements Initializable {

    @FXML
    private ImageView btnReload;
    @FXML
    private ImageView btnSearch;
    @FXML
    private JFXTextField txtEnterHere;
    @FXML
    private JFXComboBox<String> cmbSearchby;
    @FXML
    private JFXButton btnNewItem;
    @FXML
    private TableView<ItemDTO> tblStock;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnRemove;

    private QueryBO queryBO;
    
    private ItemBO itemBO;
    
    private String searchKeyword;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        queryBO = (QueryBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.QUERY);
        itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
        getAllItems();
        tblStock.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tblStock.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblStock.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("sale"));
        tblStock.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
    }    

    @FXML
    private void clickReload(MouseEvent event) {
    }

    @FXML
    private void clickSearch(MouseEvent event) {
    }

    @FXML
    private void NewItem(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/BookShopManagement/View/addItem.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void searchCustomerKey(KeyEvent event) {
    }

    @FXML
    private void selectType(ActionEvent event) {
    }

    @FXML
    private void updateItem(ActionEvent event) {
    }

    @FXML
    private void removeItem(ActionEvent event) {
        ItemDTO selectedItem = tblStock.getSelectionModel().getSelectedItem();
        try {
            boolean delete = new ItemController().deleteItem(selectedItem.getItemCode());
            if (delete) {
                getAllItems();
            } else {
            }
        } catch (Exception ex) {
            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getAllItems(){
        try {
            ArrayList<ItemDTO> allItems = itemBO.getAllItems();
            tblStock.setItems(FXCollections.observableArrayList(allItems));
        } catch (Exception ex) {
            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
