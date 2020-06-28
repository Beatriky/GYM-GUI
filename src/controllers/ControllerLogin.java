package controllers;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.ResourceBundle;

import java.util.Scanner;

import dbconnection.DBHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;


//implements initializable
public class ControllerLogin {

    public static String USERNAMEUL;

    //copy paste din scene builder -scheletul
    @FXML
    private Button login;

    @FXML
    private Button signup;
    //adaugam dupa pt conexiunea cu db
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private CheckBox rememberme;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps,pst;
    private ResultSet rs;



    public void initialize() {
        handler = new DBHandler();

    }

    /*public void getScene(String fx,String button)
    {button.getScene().getWindow().hide();

                                    try {
                                        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/fx.fxml"));
                                        Stage addStage = new Stage();
                                        addStage.setScene(new Scene(root));
                                        addStage.setTitle("The GYM- Trainer");
                                        addStage.show();
                                    }
         catch (Exception et) {
            et.getCause();
            et.printStackTrace();}}*/
    @FXML
    void onClickActionsignup() {//trimite la sign up
        signup.getScene().getWindow().hide();        //daca apesi pe butonul signup iti deschide alta casuta

        //!!! nu controller ci view!!!!
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/view/signup.fxml"));
            Stage signupStage = new Stage();
            signupStage.setScene(new Scene(root));
            signupStage.setTitle(" The GYM - SIGN UP");
            signupStage.show();

            signupStage.setTitle("Login window");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void onClickActionlogin() throws IOException {

        connection = handler.getConnection();
        String sql = "SELECT  * FROM users WHERE username = ? AND password = ?";
        System.out.println("Welcome"+USERNAMEUL);
        try {                                           //resultset.next:  if next() return false it means ResultSet is empty. Read more: https://javarevisited.blogspot.com/2016/10/how-to-check-if-resultset-is-empty-in-Java-JDBC.html#ixzz6PNi3LVLz
            connection = handler.getConnection();
            ps = connection.prepareStatement(sql);//fx:id  denumirile butoanelor/textfieldurilor
            ps.setString(1, username.getText());
            ps.setString(2, password.getText());
            rs = ps.executeQuery();

             USERNAMEUL=username.getText();

            int ok = 0;
            while (rs.next()) {
                if (rs.getObject("clientId") != null) //daca userul exista
                {       //AICI INCERSC SA SALVEZ PERS LOGATA

                  //  String content = "Hello SaveFile! I will try to save the username and password for the logged in person here!";
                    String content = "Client username : ";
                    String path = "C:\\Users\\Admints\\IdeaProjects\\GYM1final\\src\\resources\\save.txt";
                    try {
                       // Files.write(Paths.get(path), content.getBytes());
                        Files.write(Paths.get(path), USERNAMEUL.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();}



                    //mergi la fxmlul clientului
                    login.getScene().getWindow().hide();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/client.fxml"));
                        Stage addScene = new Stage();
                        addScene.setScene(new Scene(root));
                        addScene.show();
                        ok = 1;
                    } catch (Exception ec) {
                        ec.getCause();
                        ec.printStackTrace();
                        if (rs.getObject("trainerId") != null) {
                            //mergi pe trainer fxml
                            login.getScene().getWindow().hide();
                            ok = 1;
                        }
                        if (rs.getObject("managerId") != null) {
                            ok = 1;
                        }
                    }
                }

                if (rs.getObject("trainerId") != null) {
                    String content = "Trainer username : ";
                    String path = "C:\\Users\\Admints\\IdeaProjects\\GYM1final\\src\\resources\\save.txt";
                    try {Files.write(Paths.get(path), content.getBytes());
                        Files.write(Paths.get(path), USERNAMEUL.getBytes());
                    } catch (IOException e) { e.printStackTrace();}

                    //mergi pe trainer fxml
                    login.getScene().getWindow().hide();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/trainer.fxml"));
                        Stage dashboardTrainer = new Stage();
                        dashboardTrainer.setScene(new Scene(root));
                        dashboardTrainer.setTitle("The GYM- Trainer");
                        dashboardTrainer.show();
                        ok = 1;
                    } catch (Exception et) {
                        et.getCause();
                        et.printStackTrace();
                    }
                }
                if (rs.getObject("managerId") != null) {

                    String path = "C:\\Users\\Admints\\IdeaProjects\\GYM1final\\src\\resources\\save.txt";
                    try { Files.write(Paths.get(path), USERNAMEUL.getBytes());
                    } catch (IOException e) { e.printStackTrace();}

                    //mergi pe manager fxml
                    login.getScene().getWindow().hide();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/resources/view/manager.fxml"));
                        Stage dashboardTrainer = new Stage();
                        dashboardTrainer.setScene(new Scene(root));
                        dashboardTrainer.setTitle("The GYM - Manager");
                        dashboardTrainer.show();
                        ok = 1;
                    } catch (Exception em) {
                        em.getCause();
                        em.printStackTrace();
                    }

                }
            }//while
            //daca nu e gasit userul in bd
            if (ok == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username was not found in the database. Check if you spelled correctly or click the button to sign up.");
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.show();
            } else if (ok == 1)
                System.out.println("Login Succesful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickActionforgotpass(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Contact the manager, check your email or make another account.");
        alert.setTitle("Forgot password!");
        alert.show();
    }

    public void onCliackActionrememberme(ActionEvent actionEvent) {

        String sql = "SELECT  * FROM users WHERE username = ? AND password = ?";

        try {
            connection = handler.getConnection();
            pst = connection.prepareStatement(sql);//fx:id  denumirile butoanelor/textfieldurilor
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            rs = pst.executeQuery();
            String USERNAME = username.getText();
            String PASSWORD = password.getText();

            if (rememberme.isSelected()) {
                String usernpass=USERNAME+" "+PASSWORD;
                String path = "C:\\Users\\Admints\\IdeaProjects\\GYM1final\\src\\resources\\rememberme.txt";
                try {
                    Files.write(Paths.get(path),usernpass.getBytes());
                    //Files.write(Paths.get(path),PASSWORD.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    }







