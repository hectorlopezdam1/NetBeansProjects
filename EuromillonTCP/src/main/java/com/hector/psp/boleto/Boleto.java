

package com.hector.psp.boleto;

import java.io.Serializable;

/**
 * 
 * @author HectorLopez
 */
public class Boleto implements Serializable{
    
    private int[] numeros;

    public Boleto(int[] numeros) {
        this.numeros = numeros;
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    @Override
    public String toString() {
        return "Numeros: " + numeros[0] + " "+ numeros[1] + " "+ numeros[2] + " " + numeros[3] +" " + numeros[4] +
                "\nEstrellas: " + numeros[5] + " " + numeros[6] ;
    }
    
    
    
    

}
