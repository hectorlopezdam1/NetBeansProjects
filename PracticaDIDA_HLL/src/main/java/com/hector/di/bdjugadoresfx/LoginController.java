

package com.hector.di.bdjugadoresfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author HectorLopez
 */
public class LoginController {
    
    @FXML
    TextField usuario;
    
    @FXML
    PasswordField contraseña;
    
    @FXML
    Text alertText;
    
    public void entrar() throws Exception{
        
        if(usuario.getText().equals("admin") && contraseña.getText().equals("1234")){
            startApp();
        }else{
            alertText.setText("Usuario o contraseña incorrectos");
        }
    }
    
    public void register() throws IOException{
        Stage stage = new Stage();
        Parent login = new FXMLLoader().load(getClass().getResource("Register.fxml"));
        Scene escena = new Scene(login, 600, 450);
        stage.setScene(escena);
        stage.show();
        UsuarioDao usuario = new UsuarioDao();
    }
    
    public void salir(){
        System.exit(0);
    }
    
    
    
    public void startApp() throws Exception{
        Stage stage = new Stage();
        //Cargar el fxml y aplicarlo a la ventana
        Parent contenedor = new FXMLLoader().load(getClass().getResource("FormularioJugador.fxml"));
        Scene escena = new Scene(contenedor, 700, 660);
        //Aplicar los estilos css a la escena
        escena.getStylesheets().addAll(getClass().getResource("estilos.css").toExternalForm());
        stage.setTitle("Formulario Jugadores");
        Image icono = new Image("img/balon.png");
        stage.getIcons().add(icono);
        stage.setScene(escena);
        stage.show();
        
    }
    

}
