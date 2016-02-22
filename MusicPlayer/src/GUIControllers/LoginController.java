/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

/**
 *
 * @author Petter
 */
public class LoginController {
    
    @FXML private Text actiontarget;
    @FXML private TextField username = new TextField();
    @FXML private TextField password = new TextField();
    
    @FXML public void handleLoginButton(Event event){
        String user = username.getText();
        String pass = password.getText();
        //TODO get user from DB and check credentials.
        if(user.equals("Susanne") && pass.equals("deilig")) {
            ViewController.changeView("mainView.fxml");    
        }
        else {
            actiontarget.setText("Sorry wrong username or password");
        }
    }
    
    @FXML public void handleEnterPressed(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)){
            handleLoginButton(event);
        }
    }
    
}
