package com.hector.di.bdjugadoresfx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Formulario extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Cargar el fxml y aplicarlo a la ventana
        Parent contenedor = new FXMLLoader().load(getClass().getResource("FormularioJugador.fxml"));
        Scene escena = new Scene(contenedor, 700, 660);
        //Aplicar los estilos css a la escena
        escena.getStylesheets().addAll(getClass().getResource("estilos.css").toExternalForm());
        primaryStage.setTitle("Formulario Jugadores");
        Image icono = new Image("img/balon.png");
        primaryStage.getIcons().add(icono);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
    
}
