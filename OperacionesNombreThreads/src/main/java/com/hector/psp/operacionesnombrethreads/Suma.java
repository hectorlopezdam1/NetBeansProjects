

package com.hector.psp.operacionesnombrethreads;

/**
 * 
 * @author HectorLopez
 */
public class Suma extends Thread {
    
    private static String nombre;
    public static int resultado;

    public Suma(String nombre) {
       this.nombre = nombre;
    }
    
    public void run(){
        sumar();
    }

    private void sumar(){
        
        for(int i = 0; i < nombre.length(); i++){
            resultado = resultado + i + 1;
        }
        System.out.println("\nEl resultado de la suma es: " + resultado);
    }
}
