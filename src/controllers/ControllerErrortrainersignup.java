package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerErrortrainersignup {

        @FXML
        private Button gotitimtrainer;

        @FXML
        void onClickActiongotitimtrainer(ActionEvent event) throws Exception{
            gotitimtrainer.getScene().getWindow().hide();

            Parent root=FXMLLoader.load(getClass().getResource("/resources/view/login.fxml"));
            Stage addStage = new Stage();
            addStage.setScene(new Scene(root));
            addStage.show();

            addStage.setTitle("the GYM- LOG IN");
        }

        public static void main(String[] args) {


        }

    }


