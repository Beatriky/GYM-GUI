package controllers;

import dbconnection.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerCheckTrainerProfile {

    @FXML
    private ComboBox<String> cbname;
    @FXML
    private Label phone,lname,email;
    @FXML
    private Button load,trainerimage;

    @FXML
    private ImageView imagefx;

    @FXML
    private Button back,mess;

    @FXML
    private Button trainerprofile;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private ResultSet rs;
    private Component frame;


    public void initialize() {
        handler = new DBHandler();
        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select fnameT from trainers ");
            while (rs.next()) {
                cbname.getItems().addAll(rs.getString("fnameT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }}
    public String getName () { //this is for fnameC
        return (String) cbname.getSelectionModel().getSelectedItem();
    }

    @FXML
    void onClickActionload(ActionEvent event) {
        //Passing FileInputStream object as a parameter
            //FileInputStream inputstream  phone=new Label(getName());


    }
    @FXML
    void onClickActionback(ActionEvent event) {
        back.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/client.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.setTitle("The GYM-Clients");
            addScene.show();} catch (IOException e) {
            e.printStackTrace(); }
    }

    @FXML
    void onClickActiontrainerprofile(ActionEvent event) {
        trainerprofile.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/checktrainer.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.setTitle("The GYM-Trainer Details!");
            addScene.show();} catch (IOException e) {
            e.printStackTrace(); }
    }

    public void onClickactionmess(ActionEvent actionEvent) {
        mess.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/notif.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.setTitle("The GYM-Talk to the trainer!");
            addScene.show();} catch (IOException e) {
            e.printStackTrace(); }
    }

    public void onClickactionimage(ActionEvent actionEvent) {
        trainerimage.getScene().getWindow();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/trainerimage.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.setTitle("The GYM-This are our trainers!");
            addScene.show();} catch (IOException e) {
            e.printStackTrace(); }
    }
}
