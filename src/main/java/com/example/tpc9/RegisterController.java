package com.example.tpc9;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;

public class RegisterController {
    @FXML
    private Label signupMessage;
    @FXML
    private TextField pseudoTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField alcunhaTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField lnameTextField;
    @FXML
    private TextField fnameTextField;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private Button signupButton;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    public void signupButtonOnAction(ActionEvent event)  {
        if (setPasswordField.getText().equals(confirmPasswordField.getText())){
            userRegister();
            confirmPasswordLabel.setText(" ");

        }
        else {
            confirmPasswordLabel.setText("Password does not match");
        }

    }

    public void userRegister(){
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectionDB = connectNow.getConnection();

        String firstname = fnameTextField.getText();
        String lastname = lnameTextField.getText();
        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String password = setPasswordField.getText();
        String alcunha = alcunhaTextField.getText();
        String pseudonimo = pseudoTextField.getText();

        String insertFields = "insert into UserAccounts(firstName, lastName, username, password, email, pseudonimo, alcunha)values('";
        String insertValues = firstname + "', '" + lastname + "', '" + username + "', '" + password  + "', '" + email
                + "', '" + pseudonimo + "', '" + alcunha + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectionDB.createStatement();
            statement.executeUpdate(insertToRegister);
            signupMessage.setText("User Register successfully");
            System.out.wait(20);


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

}
