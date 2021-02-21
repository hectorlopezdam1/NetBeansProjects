

package com.hector.di.bdjugadoresfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.Text;

/**
 * 
 * @author HectorLopez
 */


public class RegisterController extends ControladorConNavegabilidad{

@FXML
TextField nombreUs;

@FXML
PasswordField password;

@FXML
PasswordField confirmPassword;

@FXML
Text alertText2;



   public void registrarse(){
       if(nombreUs.getText().equals("")){
           alertText2.setText("Introduce un nombre de usuario");
       }else if(password.getText().equals("")){
           alertText2.setText("introduce una contraseña");
       }else if(!password.getText().equals(confirmPassword.getText())){
           alertText2.setText("Las contraseñas no coinciden");
       }
       else{
           Usuario usuario = new Usuario(nombreUs.getText(), password.getText());
           UsuarioDao usuarioDao = new UsuarioDao(nombreUs.getText(), password.getText());
           alertText2.setText("Registrado correctamente");
       }
   }
   
   public void volverAlLogin(){
        this.layout.showScreen("login");
    }

}
