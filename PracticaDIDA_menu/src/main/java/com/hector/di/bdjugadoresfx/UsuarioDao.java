

package com.hector.di.bdjugadoresfx;

import static com.hector.di.bdjugadoresfx.JugadorDao.PASSWORD_BD;
import static com.hector.di.bdjugadoresfx.JugadorDao.URL_CONEXION;
import static com.hector.di.bdjugadoresfx.JugadorDao.USUARIO_BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author HectorLopez
 */
public class UsuarioDao {
    
    public UsuarioDao(String username, String password) {
        crearTablaSiNoExiste();
        insertarUsuarioSiNoHay(username, password);
    }

    public UsuarioDao() {
        crearTablaSiNoExiste();
    }

    private void crearTablaSiNoExiste() {
        //Asi se hace la conexion a la base de datos
        try (Connection conexionDataBase =
            DriverManager.getConnection(URL_CONEXION, USUARIO_BD, PASSWORD_BD)){
            Statement statement = conexionDataBase.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS usuario" +
                "(id INTEGER  PRIMARY KEY auto_increment, " +
                " nombre_usuario VARCHAR(255), " +
                "password VARCHAR(255));";
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void insertarUsuarioSiNoHay(String username, String password) {
        boolean existeUsuario = existeUsiario("admin", "1234");
        if(!existeUsuario){
            try (Connection conexionDataBase =
                DriverManager.getConnection(URL_CONEXION, USUARIO_BD, PASSWORD_BD)){
                Statement statement = conexionDataBase.createStatement();
                String sql = "INSERT INTO usuario (nombre_usuario, password) VALUES ('" + username + "', '" + password + "')";
                statement.executeUpdate(sql);
            }catch(Exception ex){
                throw new RuntimeException("Ocurrió un error al guardar la información: " + ex.getMessage());
            }
        }
        
    }

    private boolean existeUsiario(String username, String password) {
        try (Connection conexionDataBase =
            DriverManager.getConnection(URL_CONEXION, USUARIO_BD, PASSWORD_BD)){
            Statement statement = conexionDataBase.createStatement();
            String sql = "SELECT * FROM usuario WHERE nombre_usuario='" +
                    username + "' AND password='" + password + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet.next();
        }catch(Exception ex){
            throw new RuntimeException("Ocurrió un error al consultar la información: " + ex.getMessage());
        }
    }

}
