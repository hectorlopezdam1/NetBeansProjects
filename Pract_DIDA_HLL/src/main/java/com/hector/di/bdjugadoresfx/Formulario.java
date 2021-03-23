package com.hector.di.bdjugadoresfx;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Formulario extends Application{
    
    @Override 
    public void start(Stage primaryStage) throws Exception{
        
        LayoutPane layoutPane = new LayoutPane();
        layoutPane.loadScreen("login", LoginController.class.getResource("Login.fxml"));
        layoutPane.loadScreen("register", RegisterController.class.getResource("Register.fxml"));
        layoutPane.loadScreen("formulario", ControladorFormularioJugador.class.getResource("FormularioJugador.fxml"));
        
        layoutPane.showScreen("login");
        Scene scene = new Scene(layoutPane, 600, 400);
        Image icono = new Image("img/balon.png");
        primaryStage.getIcons().add(icono);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        
    }
    
    
    public static void main(String[] args){
        launch(args);
    }
    
    
}
