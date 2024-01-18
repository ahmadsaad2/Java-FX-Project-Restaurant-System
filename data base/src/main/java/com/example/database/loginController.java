package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import oracle.jdbc.driver.OracleDriver;

import javax.swing.*;
import java.sql.*;


public class loginController {

    @FXML
    private AnchorPane forlogin;

    @FXML
    private AnchorPane forsign;

    @FXML
    private Button login_button;

    @FXML
    private Hyperlink login_cerateAccount;

    @FXML
    private AnchorPane login_form;

    @FXML
    private Label login_label;

    @FXML
    private PasswordField login_password;

    @FXML
    private TextField login_username;

    @FXML
    private Hyperlink sign_alreadyhave;

    @FXML
    private Button sign_button;

    @FXML
    private AnchorPane sign_form;



    @FXML
    private PasswordField sign_password;

    @FXML
    private TextField sign_username1;

    @FXML
    public void changeform(ActionEvent event) {
        if (event.getSource() == sign_alreadyhave) {
            sign_form.setVisible(false);
            login_form.setVisible(true);
            forsign.setVisible(false);
            forlogin.setVisible(true);
        } else if (event.getSource() == login_cerateAccount) {
            login_form.setVisible(false);
            sign_form.setVisible(true);
            forsign.setVisible(true);
            forlogin.setVisible(false);

        }
    }


    @FXML
    private Label sign_label;




    @FXML
    private TextField sign_username;


    @FXML
    private TextField employee2;
    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }


int s;


    public void loginFunc(ActionEvent event)  {
        String username1 = login_username.getText();
        String password1 = String.valueOf(login_password.getText());

        try {
            DriverManager.registerDriver(new OracleDriver());
            String url1 = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(url1, "c##kareem", "123456");
            con.setAutoCommit(false);

            String sql = "SELECT * FROM ACCOUNTS WHERE USERNAME = ? AND PASSWORDS = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username1);
            preparedStatement.setString(2, password1);

            ResultSet resultSet = preparedStatement.executeQuery();




                if (resultSet.next()) {
                    // If a row is returned, the login is successful
                     s = resultSet.getInt("EMPLOYEETYPE");

                    // Check if the user has employee type 2 (admin)
                    if (s == 2) {



                            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
                            Parent root = loader.load();
                            HelloController dashboardController = loader.getController();

                            Stage stage = (Stage) login_username.getScene().getWindow();

                            // Set the scene to the dashboard.fxml
                            stage.setScene(new Scene(root));
                            stage.show();


                    } else if (s==1) {

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
                        Parent root = loader.load();
                        AdminController dashboardController1 = loader.getController();


                        loader.setController(dashboardController1);


                        Stage stage = (Stage) login_username.getScene().getWindow();

                        // Set the scene to the dashboard.fxml
                        stage.setScene(new Scene(root));
                        stage.show();


                    }


            } else {
                showAlert("Login failed");

                }
            preparedStatement.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public void signupfunc(ActionEvent event) throws Exception {
        String username1 = sign_username.getText();
        String password1 = String.valueOf(sign_password.getText());
        String employee12 = employee2.getText();

        try {
            DriverManager.registerDriver(new OracleDriver());
            String url1 = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(url1, "c##kareem", "123456");
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            con.commit();
            if (username1.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid Username ");

            } else if (password1.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid password ");

            } else {
                String sql2 = "SELECT USERNAME FROM Accounts WHERE USERNAME=?";
                PreparedStatement preparedStatement2 = con.prepareStatement(sql2);
                preparedStatement2.setString(1, username1);

                ResultSet resultSet = preparedStatement2.executeQuery();
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "username already exists");

                } else {
                    String sql = "INSERT INTO ACCOUNTS (USERNAME, PASSWORDS, EMPLOYEETYPE) VALUES ('" + username1 + "'," + "'" + password1 + "'," + "'" + employee12 + "')";
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.executeQuery();
                    JOptionPane.showMessageDialog(null, "Welcome " + username1);
                }
            }


            stmt.close();
            con.close();
        } catch (Exception E) {
            System.out.println("Error: " + E.getMessage());
        }

    }

    @FXML
    void switchform(MouseEvent event) {

    }

    @FXML
    void textfield(MouseEvent event) {

    }

}
