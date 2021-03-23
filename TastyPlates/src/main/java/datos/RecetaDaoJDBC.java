
package datos;

import dominio.Receta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hecti
 */
public class RecetaDaoJDBC {
    
    private static final String SQL_SELECT = "SELECT idReceta, nombre, ingredientes, pasos, puntuacion, vegano FROM receta";
    private static final String SQL_SELECT_BY_ID = "SELECT idReceta, nombre, ingredientes, pasos, puntuacion, vegano FROM receta WHERE idReceta = ?";
    private static final String SQL_INSERT = "INSERT INTO receta (nombre, ingredientes, pasos, puntuacion, vegano) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE receta SET nombre = ?,"
                                            + "ingredientes = ?,"
                                            + "pasos = ?,"
                                            + "puntuacion = ?,"
                                            + "vegano = ?"
                                            + "WHERE idReceta = ?";
    private static final String SQL_DELETE = "DELETE FROM receta WHERE idReceta = ?";
    
    public List<Receta> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Receta receta = null;
        List<Receta> recetas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
               int idReceta = rs.getInt("idReceta");
               String nombre = rs.getString("nombre");
               String ingredientes = rs.getString("ingredientes");
               String pasos = rs.getString("pasos");
               int puntuacion = rs.getInt("puntuacion");
               boolean vegano = rs.getBoolean("vegano");
               
               receta = new Receta(idReceta, nombre, ingredientes, pasos, puntuacion, vegano);
               recetas.add(receta);
            }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return recetas;
     }
    
    public Receta encontrar(Receta receta){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            
            stmt.setInt(1, receta.getIdReceta());
            rs = stmt.executeQuery();
            
            rs.absolute(1);
            
            String nombre = rs.getString("nombre");
            String ingredientes = rs.getString("ingredientes");
            String pasos = rs.getString("pasos");
            int puntuacion = rs.getInt("puntuacion");
            boolean vegano = rs.getBoolean("vegano");
            
            receta.setNombre(nombre);
            receta.setIngredientes(ingredientes);
            receta.setPasos(pasos);
            receta.setPuntuacion(puntuacion);
            receta.setVegano(vegano);
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);            
        }
        return receta;
    }
    
    public int insertar(Receta receta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, receta.getNombre());
            stmt.setString(2, receta.getIngredientes());
            stmt.setString(3, receta.getPasos());
            stmt.setInt(4, receta.getPuntuacion());
            stmt.setBoolean(5, receta.isVegano());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }
    
    public int actualizar(Receta receta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, receta.getNombre());
            stmt.setString(2, receta.getIngredientes());
            stmt.setString(3, receta.getPasos());
            stmt.setInt(4, receta.getPuntuacion());
            stmt.setBoolean(5, receta.isVegano());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }
    
    public int eliminar(Receta receta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, receta.getIdReceta());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }  
    
}
