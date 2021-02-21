/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.di.bdjugadoresfx;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 *
 * @author hecti
 */
public class ControladorJugadoresPorClub extends ControladorConNavegabilidad implements Initializable{
    
    JugadorDao jugadorDao;
    
    @FXML
    private PieChart chart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jugadorDao = new JugadorDao();
        cargarDatosEnElChart();
    }

    public void cargarDatosEnElChart() {

        Map<String, Integer> jugadoresPorClub = jugadorDao.contarJugadoresPorClub();
        ObservableList<PieChart.Data> datosParaElChart = FXCollections.observableArrayList();
        jugadoresPorClub.forEach((nombreClub, cantidad) -> {
        PieChart.Data data = new PieChart.Data(nombreClub, cantidad);
        datosParaElChart.add(data);
    });
        
        chart.setData(datosParaElChart);
        
    }
    
    public void volverAlFormulario(){
        this.layout.showScreen("formulario");
    }
    
}
