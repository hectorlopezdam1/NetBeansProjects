/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author hecti
 */
public class Receta {
    private int idReceta;
    private String nombre;
    private String ingredientes;
    private String pasos;
    private int puntuacion;
    private boolean vegano;
    
    public Receta(){
        
    }

    public Receta(int idReceta, String nombre, String ingredientes, String pasos, int puntuacion, boolean vegano) {
        this.idReceta = idReceta;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
        this.puntuacion = puntuacion;
        this.vegano = vegano;
    }

    public Receta(String nombre, String ingredientes, String pasos, int puntuacion, boolean vegano) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
        this.puntuacion = puntuacion;
        this.vegano = vegano;
    }
    
    

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public boolean isVegano() {
        return vegano;
    }

    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }
    
    
}
