package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerGymDetails {

    @FXML
    private Button platinumdet;

    @FXML
    private Button golddet;
    @FXML
    private Button back;


    @FXML
    void platinumdet(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Program orar:" +
                " Luni-Vineri: 8:00-23:00" +
                "  Sambata-Duminica: 9:00-21:00 ");
        alert.setTitle("PLATINUM GYM");
        alert.show();
    }

    @FXML
    void onClickActiongolddet(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Program orar:" +
                " Luni-Vineri: 9:00-22:00" +
                "  Sambata-Duminica: 10:00-20:00 ");
        alert.setTitle("GOLD GYM");
        alert.show();
    }
    @FXML
    void onClickActionback(ActionEvent event) {
        back.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/view/manager.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root)) ;
            addScene.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
