

package com.hector.psp.layoutsfx;

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
 * @author HectorLopez
 */
public class LayoutPane extends BorderPane{
    
    private Map<String, Node> pantallasDeLaAplicacion;
    
    public LayoutPane(){
        this.pantallasDeLaAplicacion = new HashMap<>();
    }
    
    public void cargarPantalla(String nombrePantalla, URL urlArchivoFxml) throws IOException{
        FXMLLoader cargadorPantallas = new FXMLLoader(urlArchivoFxml);
        Parent pantalla = cargadorPantallas.load();
        ControladorConNavegabilidad ccn = cargadorPantallas.getController();
        ccn.setLayout(this);
        pantallasDeLaAplicacion.put(nombrePantalla, pantalla);
    }

    public void mostrarComoPantallaActual(String nombrePantalla){
        this.setCenter(pantallasDeLaAplicacion.get(nombrePantalla));
    }
}
