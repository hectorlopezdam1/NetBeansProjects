

package datos;

import dominio.Cliente;
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
public class ClienteDaoJDBC {
    
    private static final String SQL_SELECT =
            "SELECT id_cliente, nombre, apellido, mail, telefono, saldo FROM cliente";
     private static final String SQL_SELECT_BY_ID = 
            "SELECT id_cliente, nombre, apellido, mail, telefono, saldo FROM cliente WHERE id_cliente =?";
     private static final String SQL_INSERT = 
            "INSERT INTO cliente(nombre, apellido, mail, telefono, saldo) VALUES(?, ?, ?, ?, ?)";
     private static final String SQL_UPDATE =
             "UPDATE cliente SET nombre = ?,"
             +"apellido = ?,"
             +"mail = ?,"
             +"telefono = ?,"
             +"saldo = ?,"
             +"WHERE id_cliente = ?";
     private static final String SQL_DELETE =
             "DELETE FROM cliente WHERE id_cliente = ?";
     
     public List<Cliente> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
               int idCliente = rs.getInt("id_cliente");
               String nombre = rs.getString("nombre");
               String apellido = rs.getString("apellido");
               String mail = rs.getString("mail");
               String telefono = rs.getString("telefono");
               double saldo = rs.getDouble("saldo");
               
               cliente = new Cliente(idCliente, nombre, apellido, mail, telefono, saldo);
               clientes.add(cliente);
               
               
            }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
         
     }
  public Cliente encontrar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            
            rs.absolute(1);
            
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String mail = rs.getString("mail");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");
            
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setMail(mail);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);            
        }
        return cliente;
    }
    
    public int insertar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getMail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }
    
    public int actualizar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getMail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getIdCliente());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }    
    
    public int eliminar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cliente.getIdCliente());
            
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
