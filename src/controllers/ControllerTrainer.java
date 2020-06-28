package controllers;
import dbconnection.DBHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.management.Notification;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static controllers.ControllerLogin.*;

public class ControllerTrainer  {


    @FXML
    private ComboBox cbdiet,cbex;
    @FXML
    private ComboBox cbclient;
    @FXML
    private Button back;
    @FXML
    private Button custom,seeprofile,addnewdiet,givediet;
    @FXML
    private Button checkme,addex;
    //pt adauagarea in bd
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private PreparedStatement ps1;
    private PreparedStatement ps2;
    private ResultSet rs;
    public Component frame;
    public void initialize() {
        handler = new DBHandler();
        //cb
        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select fnameC from clients ");
            while (rs.next()) {
                cbclient.getItems().addAll(rs.getString("fnameC")); //denumirea cb ului
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//cb pt diete
        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select dietType from diets ");
            while (rs.next()) {
                cbdiet.getItems().addAll(rs.getString("dietType"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //cb pt exercitii
        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select exType from exercises ");
            while (rs.next()) {
                cbex.getItems().addAll(rs.getString("exType"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String nametrainer=null,numeclient=null;

    @FXML
    void onClickActioncheckme(ActionEvent event) {
        checkme.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/notiftrainer.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();} catch (IOException e) {
            e.printStackTrace(); }

        Alert a1 = new Alert(Alert.AlertType.INFORMATION);
        a1.setTitle("Check your notifs!");
        a1.setContentText("Check out the notifications from new customers that want to collaborate with you! numeclient wants to collaborate with you!");
/*
        String text = null;
        try (Scanner scanner = new Scanner(new File("C:\\Users\\Admints\\IdeaProjects\\GYM1final\\src\\resources\\save.txt"), "UTF-8")) {
            text = scanner.useDelimiter("\\A").next();
            System.out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String userntext=text;

        System.out.println("ASTA E TEXTUL:" + text+userntext);


        String sqlch="SELECT fnameT FROM trainers where usernameT=?";
        //vr sa iau fnameT pt ca stiu username ul trainerului din text                                  AAAAAAAAGGHHHHHHHHHHHHHHHHHHHHH
        try {
            connection = handler.getConnection();
            ps2=connection.prepareStatement(sqlch);
            ResultSet rs1 = ps2.executeQuery();                    //connection.createStatement().executeQuery("SELECT fnameT FROM trainers where usernameT =?");
            while (rs1.next()) {
                ps2.setString(1,userntext);
                 nametrainer = rs1.getString("fnameT");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sqlcheck = "SELECT fnameC FROM clients where fnameT = ?";

        try {
            ps = connection.prepareStatement(sqlcheck);

            rs = ps.executeQuery();
            while (rs.next()) {
                ps.setString(1,nametrainer);
                numeclient = rs.getString("fnameC");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("ASTA E NUMELE CLIENTULUI:" + numeclient+ nametrainer);
*/


       // Exception exc = new FileNotFoundException("eyy");

    }

        public void onClickActionaddnewdiet(ActionEvent actionEvent) {
        addnewdiet.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/adddiet.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();} catch (IOException e) {
            e.printStackTrace(); }


    }
    @FXML
    void onClickActionback(ActionEvent event) {
        back.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/login.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();} catch (IOException e) {
            e.printStackTrace(); }
}
    @FXML
    void onClickActioncustom(ActionEvent event) {
        custom.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/customersdetailsT.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();} catch (IOException e) {
            e.printStackTrace();
        }catch(Exception cust){System.out.println("Ceva gresit la fxml prob");
            cust.printStackTrace();}

    }

    public void onClickActionseeprofile(ActionEvent actionEvent) {
        seeprofile.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/profileT.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();} catch (IOException e) {
            e.printStackTrace();
        }catch(Exception seeprof){System.out.println("Ceva gresit la fxml prob-see profile");
            seeprof.printStackTrace();}
    }

    public void onClickActioncbclient(ActionEvent actionEvent) {
    }

    public void onClickActioncbdiet(ActionEvent actionEvent) {
    }
    public String getNameCB () { //this is for fname Trainer
        return (String) cbclient.getSelectionModel().getSelectedItem();
    }

    public String getDietCB () { //this is for fnameC
        return (String) cbdiet.getSelectionModel().getSelectedItem();
    }

    public String getExCB () { //this is for fnameC
        return (String) cbex.getSelectionModel().getSelectedItem();
    }


    public void onClickActiongivediet(ActionEvent actionEvent) {
        connection = handler.getConnection();
        String NAMEFROMCB = getNameCB();
        try {
            String sql1 = "UPDATE clients SET dietType=? WHERE fnameC='" + getNameCB() + "'";

            ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, getDietCB());
            ps1.executeUpdate();

          //  JOptionPane.showMessageDialog(frame, "Diet Type Sent!");

        } catch (SQLException eu) {
            eu.printStackTrace();
            System.err.println("Got an exception from update! dietaa");
            System.err.println(eu.getMessage());
        }
        try {
            String sql1 = "UPDATE clients SET exType=? WHERE fnameC='" + getNameCB() + "'";

            ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, getExCB());
            ps1.executeUpdate();

            JOptionPane.showMessageDialog(frame, "Diet and exercise sent!");

        } catch (SQLException eu) {
            eu.printStackTrace();
            System.err.println("Got an exception from update-exercitii!");
            System.err.println(eu.getMessage());
        }

    }

    public void onClickActionaddex(ActionEvent actionEvent) {
        addex.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/exercise.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.setTitle("The GYM- Exercises");
            addScene.show();} catch (IOException e) {
            e.printStackTrace();
        }catch(Exception seeprof){System.out.println("Ceva gresit la fxml prob-see profile");
            seeprof.printStackTrace();}
    }

    }



