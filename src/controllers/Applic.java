package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Applic extends ControllerLogin{
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private CheckBox rememberme;
    File file = new File(System.getProperty("user.home") + "/Desktop/save.txt");
    JFrame frame = new JFrame();
    public void SAVE(){      //Save the UserName and Password (for one user)



        try {
            if(!file.exists()) file.createNewFile();  //if the file !exist create a new one

            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
            bw.write(username.getText()); //write the name
            bw.newLine(); //leave a new Line
            bw.write(password.getText()); //write the password
            bw.close(); //close the BufferdWriter

        } catch (IOException e) { e.printStackTrace(); }

    }//End Of Save




    public void UPDATE(){ //UPDATE ON OPENING THE APPLICATION

        try {
            if(file.exists()){    //if this file exists
                Scanner scan = new Scanner(file);   //Use Scanner to read the File

                username.setText(scan.nextLine());  //append the text to name field
                password.setText(scan.nextLine()); //append the text to password field
                scan.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }//End OF UPDATE
    public Applic() {
        //This will be the file where the username and password will be saved

        UPDATE(); //Check if password and this User is Saved (very simple for one user)

        if(rememberme.isSelected())
            SAVE(); //Save This UserName and his PassWord}
    }

    public String getpassword() {
        return String.valueOf(password);
    }


    public static void main(String[] args){
        new Applic();
    }
}




