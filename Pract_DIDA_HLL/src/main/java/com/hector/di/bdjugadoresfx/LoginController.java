

package com.hector.di.bdjugadoresfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class LoginController extends ControladorConNavegabilidad implements Initializable{
    
    @FXML
    TextField nombre_usuario;
    
    @FXML
    PasswordField contraseña;
    
    @FXML
    Text alertText;
    
    public void salir(){
        System.exit(0);
    }

    
    public void startApp() throws Exception{
        LayoutPane layoutPane = new LayoutPane();
        Stage stage = new Stage();
        layoutPane.loadScreen("formulario", ControladorFormularioJugador.class.getResource("FormularioJugador.fxml"));
        layoutPane.showScreen("formulario");
        Scene scene = new Scene(layoutPane, 700, 790);
        scene.getStylesheets().addAll(getClass().getResource("estilos.css").toExternalForm());
        stage.setTitle("Formulario Jugadores");
        Image icono = new Image("img/balon.png");
        stage.getIcons().add(icono);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        
    }
    
    public void registrarse(){
        this.layout.showScreen("register");
    }
    
    public void entrar(){
        if(UsuarioDao.existeUsuario(nombre_usuario.getText(), contraseña.getText())){
            try {
                Stage stage = (Stage) layout.getScene().getWindow();
                stage.hide();
                startApp();
                System.out.println("Entra");
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }else{
            alertText.setText("Usuario o contraseña incorrectos");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UsuarioDao user = new UsuarioDao();
    }
    

}
