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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import dbconnection.DBHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ControllerAddTrainer {

    @FXML
    private Button add;

    @FXML
    private TextField ln;

    @FXML
    private PasswordField password;

    @FXML
    private TextField usern;

    @FXML
    private TextField telnumber;

    @FXML
    private TextField fn;

    @FXML
    private TextField email;
    //pt adauagarea in bd
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private PreparedStatement ps1;
    private PreparedStatement ps2;
    private ResultSet rs;

    public void initialize() { //!!!!!!!!
        handler = new DBHandler();
    }


        @FXML
    void onClickActionadd(ActionEvent event) {
            connection = handler.getConnection();
            try{
                String sql1="INSERT INTO trainers(fnameT,lnameT,phoneT,emailT,usernameT)" +"VALUES(?,?,?,?,?)";

                ps1=connection.prepareStatement(sql1);
                ps1.setString(1,fn.getText());
                ps1.setString(2,ln.getText());
                ps1.setString(3,telnumber.getText());
                ps1.setString(4,email.getText());
                ps1.setString(5,usern.getText());

                ps1.executeUpdate();

                String sql = "INSERT INTO users(username, password, trainerId)" + "VALUES(?, ?, ?)";
                ps = connection.prepareStatement(sql);
                ps.setString(1, usern.getText());
                ps.setString(2, password.getText());

                String sqll = "SELECT trainerId FROM trainers WHERE fnameT = ?";
                ps2 = connection.prepareStatement(sqll);
                ps2.setString(1, fn.getText());
                rs = ps2.executeQuery();
                while(rs.next())
                    ps.setInt(3, rs.getInt("trainerId"));
                ps.executeUpdate();
                System.out.println("Trainer registered succesfully!");

                add.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/manager.fxml"));
                Stage addStage = new Stage();
                addStage.setScene(new Scene(root));
                addStage.show();
            }catch (Exception e){
                e.printStackTrace();}

}
}
