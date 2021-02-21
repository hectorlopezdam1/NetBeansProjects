

package com.hector.di.bdjugadoresfx;

import static com.hector.di.bdjugadoresfx.JugadorDao.PASSWORD_BD;
import static com.hector.di.bdjugadoresfx.JugadorDao.URL_CONEXION;
import static com.hector.di.bdjugadoresfx.JugadorDao.USUARIO_BD;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
    
   /* public void entrar() throws Exception{
        
        if(nombre_usuario.getText().equals("admin") && contraseña.getText().equals("1234")){
            startApp();
        }else{
            alertText.setText("Usuario o contraseña incorrectos");
        }
    }
    */
    public void salir(){
        System.exit(0);
    }

    
    public void startApp() throws Exception{
        LayoutPane layoutPane = new LayoutPane();
        Stage stage = new Stage();
        layoutPane.loadScreen("formulario", ControladorFormularioJugador.class.getResource("FormularioJugador.fxml"));
        layoutPane.showScreen("formulario");
        Scene scene = new Scene(layoutPane, 700, 780);
        scene.getStylesheets().addAll(getClass().getResource("estilos.css").toExternalForm());
        stage.setTitle("Formulario Jugadores");
        Image icono = new Image("img/balon.png");
        stage.getIcons().add(icono);
        stage.setScene(scene);
        stage.show();
        
    }
    
    public void registrarse(){
        this.layout.showScreen("register");
    }
    
    public void entrar(){
        try (Connection cn =
            DriverManager.getConnection(URL_CONEXION, USUARIO_BD, PASSWORD_BD)){
            Statement st = cn.createStatement();
            String query = "SELECT * FROM usuario WHERE nombre_usuario LIKE '" + nombre_usuario.getText() + "' AND password LIKE '" + contraseña.getText() + "'";
            System.out.println(nombre_usuario.getText() + contraseña.getText());
            ResultSet rs = st.executeQuery(query);
            System.out.println("test1");
            if(rs.next()){
                Stage stage = (Stage) layout.getScene().getWindow();
                stage.hide();
                startApp();
                System.out.println("Entra");
            }else{
                alertText.setText("Usuario o contraseña incorrectos");
            }
        } catch (Exception ex) {
            throw new RuntimeException("Ocurrio un error al consultar la informacion: " + ex.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UsuarioDao user = new UsuarioDao();
    }
    

}
