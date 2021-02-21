package com.hector.di.bdjugadoresfx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Formulario extends Application{
    
    
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        Parent login = new FXMLLoader().load(getClass().getResource("Login.fxml"));
        Scene escena = new Scene(login, 600, 450);
        primaryStage.setScene(escena);
        primaryStage.show();
        
    }
    
    
    public static void main(String[] args){
        launch(args);
    }
    
    
}
