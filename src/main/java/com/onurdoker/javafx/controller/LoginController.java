package com.onurdoker.javafx.controller;

import com.onurdoker.javafx.dao.UserDAO;
import com.onurdoker.javafx.dto.UserDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

// import javafx.scene.control.TextField;
// FXML dosyasındaki bileşeni Controller sınıfdındaki değişkene bağlar.
//@FXML

public class LoginController {

    /// //////////////////////////////////////////////////////////////////////////////////////
    // Field (Veri tabanı işlemleri için)
    private UserDAO userDAO = new UserDAO();

    /// //////////////////////////////////////////////////////////////////////////////////////
    // FXML Field
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    /// //////////////////////////////////////////////////////////////////////////////////////
    // ShowAlert
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    } //end showAlert

    /// //////////////////////////////////////////////////////////////////////////////////////
    // Klavyeden ENTER tuşuna bastığımda giriş yapsın
    @FXML
    private void specialOnEnterPressed(KeyEvent keyEvent) {
        // Eğer basılan tuş ENTER ise
        if (keyEvent.getCode() == KeyCode.ENTER) {
            // Eğer Enter'a basarsam login() sayfasına gitsin
            login();
        }
    } // onEnterPressed

    /// //////////////////////////////////////////////////////////////////////////////////////
    // Login
    @FXML
    public void login() {
        // Kullanıcı girişi yaparken username, password
        String username = usernameField.getText();
        String password = passwordField.getText();

        // UserDTO
        UserDTO user = userDAO.loginUser(username, password);

        // Eğer kullanıcı varsa
        if (user != null) {
            showAlert("Başarılı", "Giriş Başarılı", Alert.AlertType.INFORMATION);

            // Kayıt başarılı ise Giriş(Login) Sayfaına yönlendirsin.
            openAdminPane();
        } else {
            showAlert("Hata", "Kayıt adı veya şifre yanlış.", Alert.AlertType.ERROR);
        }
    } // end login

    /// //////////////////////////////////////////////////////////////////////////////////////
    /// // Eğer Giriş başarılı ise Admin  paneline Geçiş yapalım
    private void openAdminPane() {
        try {
            // FXML Dosyalarını Yükle
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/hamitmizrak/ecodation_javafx/view/admin.fxml"));
            Parent parent = fxmlLoader.load();

            // Var olan sahneyi alıp ve değiştirmek
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(parent));

            stage.setTitle("Admin Paneli: " + usernameField);
            stage.show();

        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
            showAlert("Hata", "Admin Sayfası Yüklenemedi", Alert.AlertType.ERROR);
        }
    }

    /// //////////////////////////////////////////////////////////////////////////////////////
    // Register (Switch)
    @FXML
    private void switchToRegister(ActionEvent actionEvent) {
        try {
            // FXML Dosyalarını Yükle
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/hamitmizrak/ecodation_javafx/view/register.fxml"));
            Parent parent = fxmlLoader.load();

            // Var olan sahneyi alıp ve değiştirmek
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(parent));
            stage.setTitle("Kayıt Ol");
            stage.show();

        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
            showAlert("Hata", "Kayıt Ekranı Yüklenemedi", Alert.AlertType.ERROR);
        }
    } //end switchToLogin

}  // end LoginController
