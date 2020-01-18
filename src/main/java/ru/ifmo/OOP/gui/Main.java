package ru.ifmo.OOP.gui;

import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.SQLException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application{
    public static void main(String args[]) throws SQLException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TODOList.fxml"));
        primaryStage.setTitle("TODOList");
        primaryStage.setScene(new Scene(root, 400, 368));
        primaryStage.show();
    }
}
