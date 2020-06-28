package controllers;

import dbconnection.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static controllers.ControllerLogin.*;

public class ControllerProfileT {

    @FXML
    private ComboBox<String> cbname;

    @FXML
    private ImageView imagefx;

    @FXML
    private Button back;
    @FXML
    private TextField hour;
    
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
                cbname.getItems().addAll(rs.getString("fnameT")); //denumirea cb ului  --campul cu care vrei sa denumesti in cb
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }}
        
    @FXML
    void onClickActionback(ActionEvent event) {
        back.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/trainer.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();} catch (IOException e) {
            e.printStackTrace(); }

    }
    public String getNameCB () { //this is for fnameC
        return (String) cbname.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    void OnClickActionhour(ActionEvent event) {
    }


    public void onClickActionsave(ActionEvent actionEvent) {
        /*
        String path = "C:\\Users\\Admints\\IdeaProjects\\GYM1final\\src\\resources\\save.txt";
        try (Scanner scanner = new Scanner( new File("C:\\Users\\Admints\\IdeaProjects\\GYM1final\\src\\resources\\save.txt"), "UTF-8" )) {
            String NUMETRAINER = scanner.useDelimiter("\\A").next();
            System.out.println(NUMETRAINER); }
        catch (FileNotFoundException e) {
            e.printStackTrace();}
        System.out.println("ASTA E USERN:"+USERNAMEUL);   */

        connection = handler.getConnection();
        String sql = "UPDATE trainers SET workhoursT=? WHERE usernameT='" + getNameCB() + "'";       //USERNAMEUL'";              //
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, hour.getText());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(frame, "Workhour set!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       // imagefx.setImage(newImg);
    }
}
