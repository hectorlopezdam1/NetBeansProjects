package com.hector.psp.layoutsfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       LayoutPane layoutPane = new LayoutPane();
       layoutPane.cargarPantalla("a", ControladorPantallaA.class.getResource("a.fxml"));
       layoutPane.cargarPantalla("a", ControladorPantallaA.class.getResource("a.fxml"));
       layoutPane.mostrarComoPantallaActual("a");
       Scene escena = new Scene(layoutPane, 400, 400);
       primaryStage.setScene(escena);
       primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}