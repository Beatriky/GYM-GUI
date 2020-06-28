package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
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
import javafx.stage.Stage;


public class ControllerManager {

    @FXML
    private Button trainerdet;

    @FXML
    private Button gymhall;

    @FXML
    private Button back;

    @FXML
    private Button addtrainer;

    @FXML
    void onClickActionback(ActionEvent event) {
        back.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/view/login.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.setTitle("The GYM-LOG IN");
            addScene.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void onClickActiongymhall(ActionEvent event) {
            gymhall.getScene().getWindow().hide();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/resources/view/gymdetails.fxml"));
                Stage addScene = new Stage();
                addScene.setScene(new Scene(root));
                addScene.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


   public void onClickActiontrainerdet(ActionEvent event) { //or you can have a popup thingie with infos
            trainerdet.getScene().getWindow().hide();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/resources/view/trainerdetails.fxml"));
                Stage addScene = new Stage();
                addScene.setScene(new Scene(root));
                addScene.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    public void onClickActionaddtrainer(ActionEvent actionEvent) {
        addtrainer.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/view/addtrainer.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
