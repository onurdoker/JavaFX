package com.onurdoker.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        /* FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show(); */

        System.out.println(getClass().getResource("view/login.fxml"));
        System.out.println(getClass().getResource("view/register.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/login.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("Kullanıcı Yönetimi");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        //launch();
        launch(args);
    }
}