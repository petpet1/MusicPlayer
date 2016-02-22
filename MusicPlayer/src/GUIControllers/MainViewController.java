/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author Petter
 */
public class MainViewController {
    @FXML private Text actiontarget;
    @FXML private GridPane targetPane;
    
    @FXML public void handleRadioGeneratorButton(ActionEvent event){
        try
        {
            targetPane.getChildren().clear();
            targetPane.getChildren().add(FXMLLoader.load(getClass().getResource("radioVIew.fxml")));
        }
        catch(Exception o)
        {
            System.out.println("faen");
            System.exit(0);
        }
    }
    
    @FXML public void handleTrackPlayerButton(ActionEvent event){
        targetPane.getChildren().clear();
        actiontarget.setText("TrackPlayer!!!");
    }
    
    @FXML public void handleAccountManagerButton(ActionEvent event){
        targetPane.getChildren().clear();
        actiontarget.setText("Account Manager!!!");
    }
    
    @FXML public void handlePlaylistButton(ActionEvent event){
        targetPane.getChildren().clear();
        actiontarget.setText("Playlist!!!");
    }
    
    @FXML public void handleSocialManagerButton(ActionEvent event){
        targetPane.getChildren().clear();
        actiontarget.setText("Social Manager!!!");
    }
    
}
