package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class ControllerTrainerImage {
    @FXML
    private Button back;

    @FXML
    void onClickActionback(ActionEvent event) {
       // back.getScene().getWindow().hide();

        try {
           Parent root = load(getClass().getClassLoader().getResource("resources/view/checktrainerprofile.fxml"));
        Stage addStage = new Stage();
        addStage.setScene(new Scene(root));
        addStage.setTitle("The GYM");
        addStage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }


}


