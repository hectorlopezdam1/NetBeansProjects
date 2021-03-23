/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.di.bdjugadoresfx;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author hecti
 */
public class LayoutPane extends BorderPane{
    
    private Map<String, Node> pantallasDeLaAplicacion;
    
    public LayoutPane(){
        this.pantallasDeLaAplicacion = new HashMap<>();
    }
    
    public void loadScreen(String nombrePantalla, URL urlArchivoFxml) throws IOException{
        FXMLLoader cargadorPantallas = new FXMLLoader(urlArchivoFxml);
        Parent pantalla = cargadorPantallas.load();
        ControladorConNavegabilidad ccn = cargadorPantallas.getController();
        ccn.setLayout(this);
        pantallasDeLaAplicacion.put(nombrePantalla, pantalla);
    }

    public void showScreen(String nombrePantalla){
        System.out.println(nombrePantalla);
        this.setCenter(pantallasDeLaAplicacion.get(nombrePantalla));
        
    }
}
