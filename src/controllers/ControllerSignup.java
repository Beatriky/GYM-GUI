package controllers;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
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

public class ControllerSignup {

    @FXML
    private Button SIGNUP;

    @FXML
    private ComboBox<String> comboboxloc;

    @FXML
    private PasswordField password;

    @FXML
    private TextField ln;

    @FXML
    private TextField usern;

    @FXML
    private TextField telnumber;

    @FXML
    private CheckBox checkboximtrainer;

    @FXML
    private TextField fn;

    @FXML
    private Button LOGIN;

    @FXML
    private TextField email;
    //pt adauagarea in bd
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private PreparedStatement ps1;
    private PreparedStatement ps2, pscb, ps3;
    private ResultSet rs, rs1,rsg;
    private Statement statement,statementcb;

    public void initialize() { //!!!!!!!!
        handler = new DBHandler();
        try{
            connection = handler.getConnection();
            statement=connection.createStatement();
            rsg=statement.executeQuery("SELECT gymLoc from gym ");
            while(rsg.next()){
                String gymloc1=rsg.getString("gymLoc");
                System.out.println(gymloc1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        comboboxloc.setItems(FXCollections.observableArrayList("Gold", "Platinum"));
        comboboxloc.setValue("Gym Name");

       // String sqlcb = "SELECT * FROM gyms";
        //String cbgym = "INSERT INTO clients(gymLoc)" + "VALUES(?)";
/*
        try {
            pscb = connection.prepareStatement(sqlcb);
           // ps3.setString(1, getGymChoice());
            rs1 = pscb.executeQuery();
            while (rs1.next()) {
                comboboxloc.getItems().addAll(rs1.getString("gymLoc"));
            }
            ps3.executeUpdate();

        } catch (Exception e) {
            e.getCause();
            e.printStackTrace();
        }*/

       // statementcb=connection.prepareStatement(cbgym);
    }


    public String getGymChoice() { //this is zahshit
        return (String) comboboxloc.getSelectionModel().getSelectedItem();
    }

    public void onClickActionSIGNUP() {

        String valuegym=getGymChoice();//very important

        System.out.println("THIS IS THE GYM VALUE:"+valuegym);
        connection = handler.getConnection();
        try {//denumirea tabelelor        FUNCTIONEAZA!!!!!
            String sql1 = "INSERT INTO clients(fnameC,lnameC,phoneC,emailC,usernameC,passwordC,gymLoc)" + "VALUES(?,?,?,?,?,?,?)";

            ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, fn.getText());
            ps1.setString(2, ln.getText());
            ps1.setString(3, telnumber.getText());
            ps1.setString(4, email.getText());
            ps1.setString(5, usern.getText());
            ps1.setString(6, password.getText());
             ps1.setString(7,valuegym);     //yas
            ps1.executeUpdate();

            String sql = "INSERT INTO users(username, password, clientId)" + "VALUES(?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, usern.getText());
            ps.setString(2, password.getText());

            String sqll = "SELECT clientId FROM clients WHERE fnameC = ?";
            ps2 = connection.prepareStatement(sqll);
            ps2.setString(1, fn.getText());
            rs = ps2.executeQuery();
            while (rs.next())
                ps.setInt(3, rs.getInt("clientId"));
            ps.executeUpdate();

            System.out.println("Client registered succesfully!");

            SIGNUP.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/login.fxml"));
            Stage addStage = new Stage();
            addStage.setScene(new Scene(root));
            addStage.show();
            addStage.setTitle("The GYM-now LOG IN ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //butonul de log in :
    @FXML
    void onClickActionLOGIN(ActionEvent event) throws IOException {
        LOGIN.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/login.fxml"));
        Stage addStage = new Stage();
        addStage.setScene(new Scene(root));
        addStage.show();
        addStage.setTitle("The GYM-LOG IN ");
    }

    //eroarea checkbox:
    @FXML
    void onClickActioncheckboximtrainer(ActionEvent event) throws IOException {
        //	boolean CBimtrainer=checkboximtrainer.isSelected();

        if (checkboximtrainer.isSelected()) {
            checkboximtrainer.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/resources/view/errortrainersignup.fxml"));

            Stage addStage = new Stage();
            addStage.setScene(new Scene(root));
            addStage.show();
            addStage.setTitle("Oopsie!");
        }
    }
}
