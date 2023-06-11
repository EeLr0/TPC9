package com.example.tpc9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {
    @FXML
    private Button cancelButton;

    @FXML
    private Label logMsg;

    @FXML
    private TextField userText;

    @FXML
    private PasswordField passText;

    @FXML
    private Label registerHere;

    public void logButtonOnAction(ActionEvent e){

        if (userText.getText().isBlank()==false && passText.getText().isBlank() ==false) {
//            logMsg.setText("You try to login");
            validateLogin();
        }
        else {
            logMsg.setText("Please enter username and password");
        }
    }

    private void validateLogin() {

        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "select count(1) from UserAccounts where username = '"+userText.getText() + "' " +
                "and password = '" + passText.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1)==1) {
                    logMsg.setText("Welcome");
                    System.out.wait(200);

                }
                else{
                    logMsg.setText("Invalid Login. Please try again");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setCancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void createAccountForm(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 520, 800);
            registerStage.setTitle("Register");
            registerStage.setScene(scene);
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void registerHereOnMouseClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
        Stage registerStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 520, 800);
        registerStage.setTitle("Register");
        registerStage.setScene(scene);
        registerStage.show();
    }
}