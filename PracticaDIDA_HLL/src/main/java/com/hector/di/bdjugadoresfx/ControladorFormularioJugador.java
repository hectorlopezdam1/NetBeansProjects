package com.hector.di.bdjugadoresfx;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;


public class ControladorFormularioJugador implements Initializable{
    
    
    @FXML
    TextField nombre;
    
    @FXML
    TextArea descripcion;
    
    @FXML
    RadioButton portero;
    
    @FXML
    RadioButton defensa;
    
    @FXML
    RadioButton centrocampista;
    
    @FXML
    RadioButton delantero;
    
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
    
    //Coge el texto de cada campo en el formulario y lo aplica al objeto jugador
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
       
       //Si no selecciona ninguna posicion sale un mensaje de informacion
       if (posicion.getText().equals("posicion")){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Seleccionar posición");
            alert.setHeaderText("Se requiere elección de posición");
            alert.setContentText("Por favor, seleccione una posición válida");
            Optional<ButtonType> result = alert.showAndWait();
            
       }//Lo mismo para el club
       else if(club.getText().equals("club")){
            Alert alert = new Alert(AlertType.INFORMATION); 
            alert.setTitle("Seleccionar club");
            alert.setHeaderText("Se requiere elección de club");
            alert.setContentText("Por favor, seleccione un club válido");
            Optional<ButtonType> result = alert.showAndWait();
       }
       
       else{//Llama al metodo de JugadorDao y luego vuelve a hacer un SELECT * FROM para refrescar la tabla
            jugadorDao.guardarOActualizar(jugador);
            id = 0;
            cargarJugadoresDeLaBase();
            nombre.clear();
            descripcion.clear();
            posicion.setText("posicion");
            goles.clear();
            nota.clear();
            club.setText("club");
        }
    }
    //Al contrario que guardar, este metodo coge los valores del objeto jugador que está en la tabla, y los pone en los campos del formulario
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
        //Alerta para confirmacion
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Jugador");
        alert.setHeaderText("Se requiere confirmación.");
        alert.setContentText("¿Seguro que desea eliminar este jugador?");

        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK){
            //Llama al metodo eliminar de JugadorDao que es un DELETE
            Jugador jugador = tablaJugadores.getSelectionModel().getSelectedItem();
            jugadorDao.eliminar(jugador);
            cargarJugadoresDeLaBase();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Llena la combobox con los elementos de la lista
        combobox2.setItems(listaComboBox2);
        //el constructor de jugadorDao es el metodo creartablasinoexiste()
        jugadorDao = new JugadorDao();
        cargarJugadoresDeLaBase();
        configurarTamanhoColumnas();
    }
    
    public void comboChanged(ActionEvent event){
        //Le da a la label de club el club seleccionado en la combobox
        club.setText(combobox2.getValue());
    }
    
    public void radioSelect(ActionEvent event){
        //Le da a la label de posicion la del radiobutton seleccionado
        if(portero.isSelected()){
            posicion.setText(portero.getText());
        }else if(defensa.isSelected()){
            posicion.setText(defensa.getText());
        }else if(centrocampista.isSelected()){
            posicion.setText(centrocampista.getText());
        }else if(delantero.isSelected()){
            posicion.setText(delantero.getText());
        }
    }
    
    //Llama al metodo buscarTodos de JugadorDao para hacer un SELECT * FROM y mostrar todos los jugadores
    private void cargarJugadoresDeLaBase() {
        ObservableList<Jugador> jugadores = FXCollections.observableArrayList();
        List<Jugador> jugadoresEncontrados = jugadorDao.buscarTodos();
        jugadores.addAll(jugadoresEncontrados);
        tablaJugadores.setItems(jugadores);
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
    
    
    

