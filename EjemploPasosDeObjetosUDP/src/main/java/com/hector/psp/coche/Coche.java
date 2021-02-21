/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.psp.coche;

import java.io.Serializable;

/**
 *
 * @author hecti
 */
@SuppressWarnings("serial")

public class Coche implements Serializable{
    
    private String matricula, modelo, marca;
    private int cv;

    public Coche(String matricula, String modelo, String marca, int cv) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.cv = cv;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", modelo=" + modelo + ", marca=" + marca + ", cv=" + cv + '}';
    }
    
    
    
}
