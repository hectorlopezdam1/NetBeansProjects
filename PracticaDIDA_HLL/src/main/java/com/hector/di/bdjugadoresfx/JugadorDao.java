package com.hector.di.bdjugadoresfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JugadorDao {
    
    public static final String URL_CONEXION = "jdbc:h2:./BDjugadoresFX";
    public static final String USUARIO_BD = "root";
    public static final String PASSWORD_BD = "hector";

    public JugadorDao() {
        crearTablaSiNoExiste();
    }

    private void crearTablaSiNoExiste() {
        //Asi se hace la conexion a la base de datos
        try (Connection conexionDataBase =
            DriverManager.getConnection(URL_CONEXION, USUARIO_BD, PASSWORD_BD)){
            Statement statement = conexionDataBase.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS jugadores" +
                "(id INTEGER auto_increment, " +
                " nombre VARCHAR(255), " +
                "descripcion VARCHAR(255)," +
                "posicion ENUM('portero', 'defensa', 'centrocampista', 'delantero')," +
                "goles INT(5)," +
                "nota DOUBLE(5)," +
                "club VARCHAR (4) )";
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void guardarOActualizar(Jugador jugador){
        //Si el jugador todavia no esta registrado se guarda, en caso contrario se actualiza
        if (jugador.getId() == 0){
            guardar(jugador);
        }else{
            actualizar(jugador);
        }
        
    }

    private void guardar(Jugador jugador) {
        
        try (Connection conexionDataBase =
            DriverManager.getConnection(URL_CONEXION, USUARIO_BD, PASSWORD_BD)){
            Statement statement = conexionDataBase.createStatement();
            String sql = "INSERT INTO jugadores(nombre, descripcion, posicion, goles, nota, club) " +
            "VALUES ('" + jugador.getNombre() + "', '" + jugador.getDescripcion() + "', '" + jugador.getPosicion() +
                    "', '" + jugador.getGoles() + "', '" + jugador.getNota() + "', '" + jugador.getClub() + "')";
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            throw new RuntimeException("Ocurrio un error al guardar la informacion: " + ex.getMessage());
        }

    }

    private void actualizar(Jugador jugador) {
        
        try (Connection conexionDataBase =
            DriverManager.getConnection(URL_CONEXION, USUARIO_BD, PASSWORD_BD)){
            Statement statement = conexionDataBase.createStatement();
            String sql = "UPDATE jugadores set nombre='" + jugador.getNombre() +
            "', descripcion='" + jugador.getDescripcion() + "', posicion='" + jugador.getPosicion() +
                    "', goles='" + jugador.getGoles() + "', nota='" + jugador.getNota() + "', club='" + jugador.getClub() + "' WHERE id=" + jugador.getId();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            throw new RuntimeException("Ocurrio un error al actualizar la informacion: " + ex.getMessage());
        }
    }
    
    public List<Jugador> buscarTodos(){
        List<Jugador> jugadores = new ArrayList<>();
        try (Connection conexionDataBase =
            DriverManager.getConnection(URL_CONEXION, USUARIO_BD, PASSWORD_BD)){
            Statement statement = conexionDataBase.createStatement();
            String sql = "SELECT * FROM jugadores ORDER BY id";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Jugador jugador = new Jugador();
                jugador.setClub(resultSet.getString("club"));
                jugador.setNota(resultSet.getDouble("nota"));
                jugador.setGoles(resultSet.getInt("goles"));
                jugador.setPosicion(resultSet.getString("posicion"));
                jugador.setDescripcion(resultSet.getString("descripcion"));
                jugador.setNombre(resultSet.getString("nombre"));
                jugador.setId(resultSet.getInt("id"));
                jugadores.add(jugador);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Ocurrio un error al consultar la informacion: " + ex.getMessage());
        }
        return jugadores;
    }
    
    public void eliminar(Jugador jugador){
        
        try (Connection conexionDataBase =
            DriverManager.getConnection(URL_CONEXION, USUARIO_BD, PASSWORD_BD)){
            Statement statement = conexionDataBase.createStatement();
            String sql = "DELETE FROM jugadores WHERE id =" + jugador.getId();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            throw new RuntimeException("Ocurrio un error al eliminar la informacion: " + ex.getMessage());
        }
        
    }
    

}
