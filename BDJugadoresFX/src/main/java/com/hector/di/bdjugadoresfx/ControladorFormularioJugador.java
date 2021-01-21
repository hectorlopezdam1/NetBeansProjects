package com.hector.di.bdjugadoresfx;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class ControladorFormularioJugador implements Initializable{
    
    
    @FXML
    TextField nombre;
    
    @FXML
    TextArea descripcion;
    
    @FXML
    ComboBox<String> combobox;
    
    ObservableList<String> listaComboBox = FXCollections.observableArrayList("portero", "defensa", "centrocampista", "delantero");
    
    @FXML
    Label posicion;
    
    @FXML
    TextField goles;
    
    @FXML
    TextField nota;
    
    @FXML
    ComboBox<String> combobox2;
    
    ObservableList<String> listaComboBox2 = FXCollections.observableArrayList("ATM", "RMA", "FCB", "RCD", "VAL", "SEV", "VIL", "ATH");
    
    @FXML
    Label club;
    
    @FXML
    TableView<Jugador> tablaJugadores;
    
    JugadorDao jugadorDao;
    
    
    int id = 0;
    
    
    public void guardar(){
       Jugador jugador = new Jugador();
       int golesint = Integer.parseInt(goles.getText());
       double notadouble = Double.parseDouble(nota.getText());
       jugador.setId(id);
       jugador.setDescripcion(descripcion.getText());
       jugador.setNombre(nombre.getText());
       jugador.setPosicion(posicion.getText());
       jugador.setClub(club.getText());
       jugador.setGoles(golesint);
       jugador.setNota(notadouble);
       
       if (posicion.getText().equals("posicion")){
            JOptionPane.showMessageDialog(null, "Por favor, introduce una posición válida");
       }else{
            jugadorDao.guardarOActualizar(jugador);
            id = 0;
            cargarJugadoresDeLaBase();
            nombre.clear();
            descripcion.clear();
            goles.clear();
            nota.clear();
            
            if(club.getText().equals("RMA")){
                JOptionPane.showMessageDialog(null,"Vinichus juega pal otro equipo", "RMA", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("@../../../../../../img/benzema.jpg")));
            }else if(club.getText().equals("ATM")){
                JOptionPane.showMessageDialog(null,"Festa do futebol!!", "ATM", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("@../../../../../../img/joaofelix.jpg")));
            }else if(club.getText().equals("FCB")){
                JOptionPane.showMessageDialog(null,"conchaetumareeeeeeee", "FCB", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("@../../../../../../img/messi.jpg")));
            }else if(club.getText().equals("RCD")){
                JOptionPane.showMessageDialog(null,"", "RCD", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("@../../../../../../img/rcd.jpg")));
            }else if(club.getText().equals("VAL")){
                JOptionPane.showMessageDialog(null,"", "VAL", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("@../../../../../../img/valemcia.png")));
            }else if(club.getText().equals("SEV")){
                JOptionPane.showMessageDialog(null,"", "SEV", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("@../../../../../../img/sevilla.png")));
            }else if(club.getText().equals("VIL")){
                JOptionPane.showMessageDialog(null,"", "VIL", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("@../../../../../../img/villarreal.jpg")));
            }else {
                JOptionPane.showMessageDialog(null,"", "ATH", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("@../../../../../../img/bilbao.png")));
            }
        }
    }
    
    public void editar(){
        Jugador jugador = tablaJugadores.getSelectionModel().getSelectedItem();
        String golesText = Integer.toString(jugador.getGoles());
        String notaText = Double.toString(jugador.getNota());
        nombre.setText(jugador.getNombre());
        descripcion.setText(jugador.getDescripcion());
        posicion.setText(jugador.getPosicion());
        goles.setText(golesText);
        nota.setText(notaText);
        club.setText(jugador.getClub());
        id = jugador.getId();
    }
    
    public void eliminar(){
        Jugador jugador = tablaJugadores.getSelectionModel().getSelectedItem();
        jugadorDao.eliminar(jugador);
        cargarJugadoresDeLaBase();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        combobox.setItems(listaComboBox);
        combobox2.setItems(listaComboBox2);
        jugadorDao = new JugadorDao();
        cargarJugadoresDeLaBase();
        configurarTamanhoColumnas();
    }
    
    public void comboChanged(ActionEvent event){
        posicion.setText(combobox.getValue());
        club.setText(combobox2.getValue());
    }
    

    private void cargarJugadoresDeLaBase() {
        ObservableList<Jugador> departamentos = FXCollections.observableArrayList();
        List<Jugador> jugadoresEncontrados = jugadorDao.buscarTodos();
        departamentos.addAll(jugadoresEncontrados);
        tablaJugadores.setItems(departamentos);
    }
    
    
    private void configurarTamanhoColumnas(){
        tablaJugadores.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        ObservableList<TableColumn<Jugador, ?>> columnas = tablaJugadores.getColumns();
        columnas.get(0).setMaxWidth(1f * Integer.MAX_VALUE * 12); 
        columnas.get(1).setMaxWidth(1f * Integer.MAX_VALUE * 15); 
        columnas.get(2).setMaxWidth(1f * Integer.MAX_VALUE * 33); 
        columnas.get(3).setMaxWidth(1f * Integer.MAX_VALUE * 16);
        columnas.get(4).setMaxWidth(1f * Integer.MAX_VALUE * 10);
        columnas.get(5).setMaxWidth(1f * Integer.MAX_VALUE * 10);
        columnas.get(6).setMaxWidth(1f * Integer.MAX_VALUE * 4);
        
    }
    
}
    
    
    

