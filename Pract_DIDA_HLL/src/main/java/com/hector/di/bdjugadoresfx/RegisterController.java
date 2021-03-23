

package com.hector.di.bdjugadoresfx;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
       if(nombreUs.getText().equals(""))
           alertText2.setText("Introduce un nombre de usuario");
       else if(password.getText().equals(""))
           alertText2.setText("Introduce una contraseña");
       else if(!password.getText().equals(confirmPassword.getText()))
           alertText2.setText("Las contraseñas no coinciden");
       else if(UsuarioDao.existeUsuarioReg(nombreUs.getText()))
           alertText2.setText("Este nombre de usuario ya está en uso");
       else{
           UsuarioDao usuarioDao = new UsuarioDao(nombreUs.getText(), password.getText());
           alertText2.setText("Registrado correctamente");
       }
   }
   
   public void volverAlLogin(){
        this.layout.showScreen("login");
    }

}
