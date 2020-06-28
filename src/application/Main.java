package application;

//import controllers.Applic;
import controllers.ControllerSubscription2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static controllers.ControllerSubscription2.TRAINERALES;


public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("/resources/view/checktrainerprofile.fxml"));	//afisarea loginului

    primaryStage.setTitle("Welcome to The GYM");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);

    }


}