

package com.hector.psp.operacionesnombrethreads;

/**
 * 
 * @author HectorLopez
 */
public class SustituirVocales extends Thread {

    private static String nombre;
    private static String nuevoNombre = "";

    public SustituirVocales(String nombre) {
        this.nombre = nombre;
    }
    
    public void run(){
        sustituirVocales();
    }
    
    private void sustituirVocales() {
        System.out.print("\nSustituimos las vocales por '@': ");
        nombre = nombre.toLowerCase();
        for(int i = 0; i < nombre.length(); i++){
            
            if(nombre.charAt(i) == 'a' || nombre.charAt(i) == 'e' || nombre.charAt(i) == 'i' || nombre.charAt(i) == 'o' || nombre.charAt(i) == 'u'){
                nuevoNombre = nuevoNombre + "@";
            }else{
                nuevoNombre = nuevoNombre + nombre.charAt(i);
            }
        }
        System.out.println(nuevoNombre);
    }
    
    
    
}
