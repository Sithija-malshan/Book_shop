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
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.CustomerBO;
import lk.ijse.BookShopManagement.Bo.Custom.QueryBO;
import lk.ijse.BookShopManagement.Db.DBConnection;
import lk.ijse.BookShopManagement.Dto.CustomerDTO;
import lk.ijse.BookShopManagement.EntityController.CustomerController;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author malsh
 */
public class CustomersController implements Initializable {

    private QueryBO queryBO;

    private CustomerBO customerBO;

    private String searchByKeyword;

    public static String cusId;
    public static String name;
    public static int contact;
    public static String address;

    @FXML
    private AnchorPane paneCus;
    @FXML
    private ImageView btnReload;
    @FXML
    private ImageView btnSearch;
    @FXML
    private TableView<CustomerDTO> tblCustomer;
    @FXML
    private JFXTextField txtType;
    @FXML
    private JFXComboBox<String> cmbSearchBy;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnRemove;
    @FXML
    private ImageView report;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        queryBO = (QueryBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.QUERY);
        customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
        loadSearchByName();
        //searchByKeyword = "name";
        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cusId"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));

        getAllCustomer();

    }

    @FXML
    private void clickReload(MouseEvent event) {
    }

    @FXML
    private void clickSearch(MouseEvent event) {
    }

    @FXML
    private void searchCustomerKey(KeyEvent event) {
        String selectedItem = cmbSearchBy.getSelectionModel().getSelectedItem();
        String keyWord = txtType.getText();

        try {
            ArrayList<CustomerDTO> searchCustomer = customerBO.getSearchCustomer(selectedItem, keyWord);
            tblCustomer.setItems(FXCollections.observableArrayList(searchCustomer));
        } catch (Exception ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void chooseType(ActionEvent event) {
        searchByKeyword = cmbSearchBy.getValue();
    }

    private void loadSearchByName() {
        try {
            ArrayList<String> tblColumn = queryBO.getTableColumn("customer");
            for (String name : tblColumn) {
                cmbSearchBy.getItems().add(name);
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getAllCustomer() {
        try {
            ArrayList<CustomerDTO> allCustomers = customerBO.getAllCustomers();
            tblCustomer.setItems(FXCollections.observableArrayList(allCustomers));
        } catch (Exception ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateCustomer(ActionEvent event) throws IOException {
        CustomerDTO selectedItem = tblCustomer.getSelectionModel().getSelectedItem();
        cusId = selectedItem.getCusId();
        name = selectedItem.getName();
        contact = selectedItem.getContact();
        address = selectedItem.getAddress();

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/BookShopManagement/View/updateCustomer.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void removeCustomer(ActionEvent event) {
        CustomerDTO selectedCus = tblCustomer.getSelectionModel().getSelectedItem();
        try {
            boolean delete = new CustomerController().deleteCustomer(selectedCus.getCusId());
            if (delete) {
                getAllCustomer();
            } else {
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickReportBTN(MouseEvent event) {
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
}
