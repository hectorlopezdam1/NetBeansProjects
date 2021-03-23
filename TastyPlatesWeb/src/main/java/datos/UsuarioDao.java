

package datos;

import dominio.Receta;
import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author HectorLopez
 */
public class UsuarioDao extends Conexion{

    private final String SQL_SELECT = "SELECT idUser, email, password FROM user;";
    private final String SQL_SELECT_BY_ID = "SELECT email, password FROM user WHERE idUser = ?;";
    
    public List<Usuario> listarUsuarios(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idUser = rs.getInt("idUser");
                String email = rs.getString("email");
                String password = rs.getString("password");
                usuario = new Usuario(idUser);
                usuarios.add(usuario);
            }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios;
    }
    
    public boolean checkLogin(String email, String password){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String query = "SELECT * FROM user WHERE email = ? AND password = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            
            if(rs.next()){
                return true;
            }
        }catch(Exception ex){
            System.err.println("Error " + ex);
        }finally{
            try{
                if(getConnection() != null) getConnection().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            }catch(Exception ex){
                System.err.println("Error " + ex);
            }
        }
        return false;
    }
    
    public boolean register(String email, String password, String nombre, String apellido){
        PreparedStatement pst = null;
        try{
            String insert = "INSERT INTO user (email, password, nombre, apellido) VALUES (?, ?, ?, ?)";
            pst = getConnection().prepareStatement(insert);
            pst.setString(1, email);
            pst.setString(2, password);
            pst.setString(3, nombre);
            pst.setString(4, apellido);
            
            if(pst.executeUpdate() == 1){
                return true;
            }
        }catch(Exception ex){
            System.err.println("Error " + ex);
        }finally{
            try{
                if(getConnection() != null) getConnection().close();
                if(pst != null) pst.close();
            }catch(Exception ex){
                System.err.println("Error " + ex);
            }
        }
        return false;
    }

}
