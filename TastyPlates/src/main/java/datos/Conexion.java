/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author hecti
 */
public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tastyrecipes?zeroDateTimeBehavior=convertToNull&useTimezone=true&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "hector";
    
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        ds.setInitialSize(50);//max 50 conexiones
        return ds;
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs){
        try{
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try{
            stmt.close();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try{
            conn.close();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
}
