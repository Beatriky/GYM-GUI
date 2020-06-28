package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;
import dbconnection.DBHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static javafx.fxml.FXMLLoader.load;

public class ControllerClient {
    @FXML
    private Button feedback;

    @FXML
    private Button checktrainers;

    @FXML
    private Button clientsub,rate;

    @FXML
    private Button logout,explan;
    @FXML
    void onClickActionclientsub(ActionEvent event)throws IOException  {
        clientsub.getScene().getWindow().hide();
        try {
            Parent root = load(getClass().getResource("/resources/view/subscription.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();
            addScene.setTitle("The GYM-Subscription!");
        }catch (IOException e) {
            e.printStackTrace(); }
    }

    @FXML
    void onClickActionfeedback(ActionEvent event)throws IOException  {
       feedback.getScene().getWindow().hide();
       try {
           Parent root = load(getClass().getResource("/resources/view/feedback.fxml"));
           Stage addScene = new Stage();
           addScene.setScene(new Scene(root));
           addScene.show();
           addScene.setTitle("The GYM-Feedback!");
       }catch (IOException e) {
           e.printStackTrace(); }
    }


    @FXML
    void onClickActionchecktrainers(ActionEvent event) {
        checktrainers.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/checktrainerprofile.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();
            addScene.setTitle("The GYM-Check out the trainers!");
        }catch (IOException e) {
            System.out.println("Prob fxlm scris gresit");
            e.printStackTrace(); }
    }

    @FXML
    void onClickActionlogout(ActionEvent event){
        logout.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/login.fxml"));
        Stage addStage = new Stage();
        addStage.setScene(new Scene(root));
        addStage.show();
        addStage.setTitle("The GYM-LOG IN ");}catch (IOException e) {
            e.printStackTrace(); }
    }
    @FXML
    void onClickActionrate(ActionEvent event){
        rate.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/ratetrainers.fxml"));
            Stage addStage = new Stage();
            addStage.setScene(new Scene(root));
            addStage.show();
            addStage.setTitle("The GYM-LOG IN ");}catch (IOException e) {
            e.printStackTrace(); }
    }

    public void onClickActionexplan(ActionEvent actionEvent) {
        explan.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/plan.fxml"));
            Stage addStage = new Stage();
            addStage.setScene(new Scene(root));
            addStage.show();
            addStage.setTitle("The GYM-Exercise Plan <3");}catch (IOException e) {
            e.printStackTrace(); }
    }
}
