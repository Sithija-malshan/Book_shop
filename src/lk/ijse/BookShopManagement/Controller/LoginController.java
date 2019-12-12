/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.BookShopManagement.Bo.BOFactory;
import lk.ijse.BookShopManagement.Bo.Custom.LoginBO;

/**
 * FXML Controller class
 *
 * @author malsh
 */
public class LoginController implements Initializable {

    @FXML
    private JFXButton btnLogin;
    @FXML
    private ImageView btnCloseLogin;
    @FXML
    private AnchorPane loginPane;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPassword;
    LoginBO loginBO;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), loginPane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }    

    public LoginController() {
        loginBO=(LoginBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.LOGIN);
    }

    
    @FXML
    private void clickBtnLogin(ActionEvent event) throws IOException, Exception {
//        String name = txtUserName.getText();
//        String pw = txtPassword.getText();
//        
//        String Encrypt = Encription.Encrypt(pw);
//        System.out.println(Encrypt);
//        String checkPassword = loginBO.checkPassword(name);
//        System.out.println(checkPassword+"  retund");
//        
//        if(Encrypt.equalsIgnoreCase(checkPassword)){
            Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/BookShopManagement/View/dashboard.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) loginPane.getScene().getWindow();
            stage.setScene(scene);

            TranslateTransition transition=new TranslateTransition(Duration.millis(300), scene.getRoot());
            transition.setFromX(scene.getWidth());
            transition.setToX(0.0);
            transition.play();

        
//        }else{new Alert(Alert.AlertType.ERROR,"Worng Password Try Again", ButtonType.OK).show();}
        
    }

    @FXML
    private void clickLoginClose(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void enterUserName(ActionEvent event) {
        txtPassword.requestFocus();
    }

    @FXML
    private void enterPassword(ActionEvent event) throws Exception {
        clickBtnLogin(event);
    }
    
}
