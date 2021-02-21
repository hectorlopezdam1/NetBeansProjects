package com.hector.di.bdjugadoresfx;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;


public class ControladorFormularioJugador extends ControladorConNavegabilidad implements Initializable{
    
    
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
    TextField goles;
    
    @FXML
    TextField nota;
    
    @FXML
    ComboBox<String> combobox2;
    
    ObservableList<String> listaComboBox2 = FXCollections.observableArrayList("ATM", "RMA", "FCB", "RCD", "VAL", "SEV", "VIL", "ATH");
    
    @FXML
    TableView<Jugador> tablaJugadores;
    
    @FXML
    MenuBar menuBar;
    
    @FXML
    Menu archivo;
    
    @FXML
    Menu opciones;
    
    @FXML
    Menu ayuda;
    
    JugadorDao jugadorDao;
    
    
    
    int id = 0;
    
    //Coge el texto de cada campo en el formulario y lo aplica al objeto jugador
    public void guardar(){
        if(!isInteger(goles.getText())){
            Alert alert = new Alert(AlertType.INFORMATION); 
            alert.setTitle("Tipo de dato no válido");
            alert.setContentText("Introduce un número entero en el campo 'goles'");
            alert.show();
       }
       Jugador jugador = new Jugador();
       int golesint = Integer.parseInt(goles.getText());
       double notadouble = Double.parseDouble(nota.getText());
       jugador.setId(id);
       jugador.setDescripcion(descripcion.getText());
       jugador.setNombre(nombre.getText());
       if(portero.isSelected()){
           jugador.setPosicion("portero");
       }else if(defensa.isSelected()){
           jugador.setPosicion("defensa");
       }else if(centrocampista.isSelected()){
           jugador.setPosicion("centrocampista");
       }else if(delantero.isSelected()){
           jugador.setPosicion("delantero");
       }
       jugador.setClub(combobox2.getValue());
       jugador.setGoles(golesint);
       jugador.setNota(notadouble);
       
       //Si no selecciona ninguna posicion sale un mensaje de informacion
       if (!portero.isSelected() && !defensa.isSelected() && !centrocampista.isSelected() && !delantero.isSelected()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Seleccionar posición");
            alert.setContentText("Por favor, seleccione una posición válida");
            alert.show();
            
       }//Lo mismo para el club
       if(combobox2.getValue().equals("Club")){
            Alert alert = new Alert(AlertType.INFORMATION); 
            alert.setTitle("Seleccionar club");
            alert.setContentText("Por favor, seleccione un club válido");
            alert.show();
       }
       
       if(notadouble < 0 || notadouble > 10){
           Alert alert = new Alert(AlertType.INFORMATION); 
            alert.setTitle("Nota no válida");
            alert.setContentText("La nota debe ser un valor entre 0 y 10");
            alert.show();
       }
       
       
       
       else{//Llama al metodo de JugadorDao y luego vuelve a hacer un SELECT * FROM para refrescar la tabla
            jugadorDao.guardarOActualizar(jugador);
            id = 0;
            cargarJugadoresDeLaBase();
            nombre.clear();
            descripcion.clear();
            combobox2.setValue("Club");
            goles.clear();
            nota.clear();
            if (portero.isSelected()){
                portero.setSelected(false);
            }else if(defensa.isSelected()){
                defensa.setSelected(false);
            }else if(centrocampista.isSelected()){
                centrocampista.setSelected(false);
            }else if(delantero.isSelected()){
                delantero.setSelected(false);
            }
        }
    }
    //Al contrario que guardar, este metodo coge los valores del objeto jugador que está en la tabla, y los pone en los campos del formulario
    public void editar(){
        Jugador jugador = tablaJugadores.getSelectionModel().getSelectedItem();
        String golesText = Integer.toString(jugador.getGoles());
        String notaText = Double.toString(jugador.getNota());
        nombre.setText(jugador.getNombre());
        descripcion.setText(jugador.getDescripcion());
        if(jugador.getPosicion().equals("portero")){
            portero.setSelected(true);
        }else if(jugador.getPosicion().equals("defensa")){
            defensa.setSelected(true);
        }else if(jugador.getPosicion().equals("centrocampista")){
            centrocampista.setSelected(true);
        }else{
            delantero.setSelected(true);
        }
        combobox2.setValue(jugador.getClub());
        goles.setText(golesText);
        nota.setText(notaText);
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
        combobox2.setItems(listaComboBox2);
        jugadorDao = new JugadorDao();
        cargarJugadoresDeLaBase();
        configurarTamanhoColumnas();
    }
    
    
    //Llama al metodo buscarTodos de JugadorDao para hacer un SELECT * FROM y mostrar todos los jugadores
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
    
    private boolean isInteger(String goles){
        try{
            Integer.parseInt(goles);
        }catch(NumberFormatException | NullPointerException e){
            return false;
        }
        return true;
    }
    
    public void mostrarGrafico() throws IOException{
        layout.loadScreen("grafico", ControladorJugadoresPorClub.class.getResource("JugadoresPorClub.fxml"));
        layout.showScreen("grafico");
    }
    
}
    
    
    

