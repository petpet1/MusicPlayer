/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Petter
 */
public class ViewController extends Application {
    
    private static Stage stage;
    private static Parent root;
    private static ViewController instance;
    
    public ViewController()
    {
        instance = this;
    }
    
    public static ViewController getInstance()
    {
        return instance;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        root = FXMLLoader.load(getClass().getResource("login.fxml"));        
        Scene scene = new Scene(root, 900, 700);
        
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void changeView(String fxml)
    {
        try
        {
            Parent page = (Parent) FXMLLoader.load(ViewController.class.getResource(fxml));
            Scene scene = stage.getScene();
            if(scene == null)
            {
                scene = new Scene(page,700, 900);
                stage.setScene(scene);
            }
            else
            {
                stage.getScene().setRoot(page);
            }
            stage.sizeToScene();  
        }
        catch(Exception e)
        {
            System.out.println("faen");
            System.exit(0);
        }
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
