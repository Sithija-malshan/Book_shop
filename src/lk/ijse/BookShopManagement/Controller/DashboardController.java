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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.BookShopManagement.Dto.CustomerDTO;
import lk.ijse.BookShopManagement.Dto.CustomerOrderDTO;
import lk.ijse.BookShopManagement.Dto.CustomerOrderDetailDTO;
import lk.ijse.BookShopManagement.Dto.ItemDTO;
import lk.ijse.BookShopManagement.EntityController.CustomerController;
import lk.ijse.BookShopManagement.EntityController.CustomerOrderController;
import lk.ijse.BookShopManagement.EntityController.ItemController;
import lk.ijse.BookShopManagement.View.util.tblmodel.CustomerOrderTM;

/**
 * FXML Controller class
 *
 * @author malsh
 */
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private JFXButton btnCusOrder;
    @FXML
    private JFXButton btnCustomer;
    @FXML
    private JFXButton btnSupOrder;
    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView btnLogout;
    @FXML
    private Label lblHours;
    @FXML
    private Label lblMinute;
    @FXML
    private JFXButton btnSupplier;
    @FXML
    private JFXButton btnStock;
    @FXML
    private JFXButton btnReport;
    @FXML
    private JFXButton btnSetting;
    @FXML
    private AnchorPane cusOrderPane;
    @FXML
    private JFXTextField txtSearchCus;
    @FXML
    private Label lblCusName;
    @FXML
    private JFXButton btnRemove;
    @FXML
    private JFXButton btnNewCus;
    @FXML
    private JFXButton btnPlaceOrder;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblSec;
    @FXML
    private JFXTextField txtSearchItem;
    @FXML
    private JFXTextField txtAmount;
    @FXML
    private Label lblTotal;
    @FXML
    private JFXComboBox<String> cmbCustomer;
    @FXML
    private JFXComboBox<String> cmbItem;
    @FXML
    private Label lblDescription;
    @FXML
    private Label lblUnitPrice;
    @FXML
    private Label lblQtyonHand;
    @FXML
    private JFXTextField txtDiscount;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private TableView<CustomerOrderTM> tblCusOrder;
    
    private ObservableList<CustomerOrderTM> olOderDetails;
    
    private boolean update = false;
    @FXML
    private Label lblBalance;
    @FXML
    private Label lblOrderID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadDateTime();
        loadOrderId();
        loadAllCustomers();
        loadAllItems();
        
        tblCusOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tblCusOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblCusOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblCusOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblCusOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("discount"));
        tblCusOrder.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("total"));
        
        olOderDetails = FXCollections.observableArrayList();
        tblCusOrder.setItems(olOderDetails);
        
        tblCusOrder.getItems().addListener(new ListChangeListener<CustomerOrderTM>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends CustomerOrderTM> c) {
                double total = 0.00;
                
                for (CustomerOrderTM orderDetail : olOderDetails) {
                    total += orderDetail.getTotal();
                }
                lblTotal.setText(total+"");
            }
        });
        
        tblCusOrder.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerOrderTM>() {
            @Override
            public void changed(ObservableValue<? extends CustomerOrderTM> observable, CustomerOrderTM oldValue, CustomerOrderTM newValue) {
                
                CustomerOrderTM currentRow = observable.getValue();
                
                if (currentRow == null) {
                    cmbItem.getSelectionModel().clearSelection();
                    update = false;
                    btnRemove.setDisable(true);
                    return;
                }
                update = true;
                String itemCode = currentRow.getItemCode();
                btnRemove.setDisable(false);
                
                cmbItem.getSelectionModel().select(itemCode);
                txtQty.setText(currentRow.getQty() +"");
            }
        });
        btnRemove.setDisable(true);
    }    
    private void loadDateTime(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e ->{
            lblDate.setText(LocalDate.now().toString());
            lblHours.setText(LocalTime.now().getHour()+"");
            lblMinute.setText(LocalTime.now().getMinute()+"");
            lblSec.setText(LocalTime.now().getSecond()+"");
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
    private void loadAllCustomers(){
        try {
            ArrayList<CustomerDTO> allCustomers = new CustomerController().getAllCustomer();
            for (CustomerDTO allCustomer : allCustomers) {
                cmbCustomer.getItems().add(allCustomer.getCusId());
            }
        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void loadAllItems() {
        try {
            ArrayList<ItemDTO> allItems = new ItemController().getAllItem();
            for (ItemDTO allItem : allItems) {
                cmbItem.getItems().add(allItem.getItemCode());
            }
        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void clear(){
        txtSearchItem.setText("");
        lblDescription.setText("");
        lblUnitPrice.setText("");
        lblQtyonHand.setText("");
        txtDiscount.setText("");
        txtQty.setText("");
    }
    
    private void loadOrderId(){
        int i = new Random().nextInt(900);
        lblOrderID.setText("OD" + i);
    }
    
    
    @FXML
    private void ClickCusOrder(MouseEvent event) {
        try {            
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/BookShopManagement/View/dashboard.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) this.btnCusOrder.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ClickCustomers(MouseEvent event) {
        try {
            Node n = FXMLLoader.load(this.getClass().getResource("/lk/ijse/BookShopManagement/View/customers.fxml"));
            if(!cusOrderPane.getChildren().isEmpty()){
                cusOrderPane.getChildren().remove(0);
            }
            cusOrderPane.getChildren().add(n);
            
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ClickSupOrder(MouseEvent event) {
        try {
            Node n = FXMLLoader.load(this.getClass().getResource("/lk/ijse/BookShopManagement/View/supplierOrder.fxml"));
            if(!cusOrderPane.getChildren().isEmpty()){
                cusOrderPane.getChildren().remove(0);
            }
            cusOrderPane.getChildren().add(n);
            
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ClickClose(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void ClickLogout(MouseEvent event) {
        try {
            Parent root =  FXMLLoader.load(getClass().getResource("/lk/ijse/BookShopManagement/View/login.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) this.btnLogout.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            
            TranslateTransition tt=new TranslateTransition(Duration.millis(350),scene.getRoot());
            tt.setFromY(+scene.getWidth());
            tt.setToY(0);
            tt.play();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ClickSupplier(MouseEvent event) {
        try {
            Node n = FXMLLoader.load(this.getClass().getResource("/lk/ijse/BookShopManagement/View/suppliers.fxml"));
            if(!cusOrderPane.getChildren().isEmpty()){
                cusOrderPane.getChildren().remove(0);
            }
            cusOrderPane.getChildren().add(n);
            
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ClickStock(MouseEvent event) {
        try {
            Node n = FXMLLoader.load(this.getClass().getResource("/lk/ijse/BookShopManagement/View/stock.fxml"));
            if(!cusOrderPane.getChildren().isEmpty()){
                cusOrderPane.getChildren().remove(0);
            }
            cusOrderPane.getChildren().add(n);
            
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ClickReports(MouseEvent event) {
        try {
            Node n = FXMLLoader.load(this.getClass().getResource("/lk/ijse/BookShopManagement/View/report.fxml"));
            if (!cusOrderPane.getChildren().isEmpty()) {
                cusOrderPane.getChildren().remove(0);
            }
            cusOrderPane.getChildren().add(n);
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ClickSettings(MouseEvent event) {
        try {
            Node n = FXMLLoader.load(this.getClass().getResource("/lk/ijse/BookShopManagement/View/settings.fxml"));
            if(!cusOrderPane.getChildren().isEmpty()){
                cusOrderPane.getChildren().remove(0);
            }
            cusOrderPane.getChildren().add(n);
            
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void NewCustomer(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/BookShopManagement/View/addCustomer.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void PlaceOrder(MouseEvent event) {
        try {
            String odId = lblOrderID.getText();
            String cusId = cmbCustomer.getValue();
            String date = lblDate.getText();
            double total = Double.parseDouble(lblTotal.getText());
            
            ArrayList<CustomerOrderDetailDTO> allOrderDetails = new ArrayList<>();
            ArrayList<ItemDTO> orderItems = new ArrayList<>();
            
            for (int i = 0; i < tblCusOrder.getItems().size(); i++) {
                String itemId = tblCusOrder.getItems().get(i).getItemCode();
                int orderQty = tblCusOrder.getItems().get(i).getQty();
                double price = tblCusOrder.getItems().get(i).getTotal();
                CustomerOrderDetailDTO orderDetail = new CustomerOrderDetailDTO(odId, itemId, orderQty, price);
                allOrderDetails.add(orderDetail);
                ItemDTO items = new ItemDTO(itemId, date, itemId, odId, total, price, orderQty);
                orderItems.add(items);
            }
            CustomerOrderDTO orders = new CustomerOrderDTO(odId, cusId, date, total, allOrderDetails, orderItems);
            boolean addOrder = new CustomerOrderController().addCusOrder(orders);
            if (addOrder) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Order Placed", ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.setHeaderText("Something went wrong");
            alert.show();
        }
        
    }

    @FXML
    private void CancelOrder(MouseEvent event) {
        ClickCusOrder(event);
    }

    @FXML
    private void EnterItemCode(ActionEvent event) {
        
    }

    @FXML
    private void EnterContact(ActionEvent event) {
        try {
            String cusContact = txtSearchCus.getText();
            CustomerDTO searchCus = new CustomerController().searchContact(cusContact);
            if (searchCus != null) {
                cmbCustomer.getSelectionModel().select(searchCus.getCusId());
                lblCusName.setText(searchCus.getName());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No Such Customer", ButtonType.OK);
                alert.show();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void EnterQty(ActionEvent event) {
        
        String itemCode = txtSearchItem.getText();
        int discount = Integer.parseInt(txtDiscount.getText());
        int qty = Integer.parseInt(txtQty.getText());
        double unitPrice = Double.parseDouble(lblUnitPrice.getText());
        
        if (!update) {
            for (CustomerOrderTM orderDetail : olOderDetails) {
                if (orderDetail.getItemCode().equals(itemCode)) {
                    Alert error = new Alert(Alert.AlertType.ERROR, "Please update the item instead of adding", ButtonType.OK);
                    error.setHeaderText("Duplicate Entry Found");
                    error.setTitle("Duplicate Error");
                    error.show();
                    return;
                }
            }
        }
        
        CustomerOrderTM orderDeail = new CustomerOrderTM(
                itemCode, 
                lblDescription.getText(), 
                unitPrice, 
                qty, 
                discount, 
                ((100 - discount) * (qty * unitPrice)) / 100
        );
        
        if (!update) {
            olOderDetails.add(orderDeail);
            tblCusOrder.setItems(olOderDetails);
        } else {
            CustomerOrderTM selectedRow = tblCusOrder.getSelectionModel().getSelectedItem();
            
            int index = olOderDetails.indexOf(selectedRow);
            
            olOderDetails.set(index, orderDeail);
        }
        clear();
        cmbItem.requestFocus();
    }

    @FXML
    private void ChooseCustomer(ActionEvent event) {
        try {
            String customerId = cmbCustomer.getValue();
            CustomerDTO customer = new CustomerController().searchCustomer(customerId);
            txtSearchCus.setText(customer.getContact() + "");
            lblCusName.setText(customer.getName());
        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void ChooseItem(ActionEvent event) {
        try {
            String itemCode = cmbItem.getValue();
            ItemDTO item = new ItemController().searchItem(itemCode);
            txtSearchItem.setText(item.getItemCode());
            lblDescription.setText(item.getDescription());
            lblUnitPrice.setText(item.getSale()+"");
            lblQtyonHand.setText(item.getQty()+"");
        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void EnterDiscount(ActionEvent event) {
        txtQty.requestFocus();
    }

    @FXML
    private void removeRow(ActionEvent event) {
        CustomerOrderTM selectedRow = tblCusOrder.getSelectionModel().getSelectedItem();
        olOderDetails.remove(selectedRow);
        txtQty.setText("");
        cmbItem.requestFocus();
    }

    @FXML
    private void enterPaidAmount(ActionEvent event) {
        double totalPay = Double.parseDouble(lblTotal.getText());
        double paidAmount = Double.parseDouble(txtAmount.getText());
        if (paidAmount>=totalPay) {
            double balance = paidAmount - totalPay;
            lblBalance.setText(balance + "");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Less Than Total Payment", ButtonType.OK);
            alert.show();
        }
    }

    
    
}
