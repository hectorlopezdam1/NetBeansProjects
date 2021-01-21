

package com.hector.psp.operacionesnombrethreads;

import java.util.Scanner;

/**
 * 
 * @author HectorLopez
 */

/*
Introducir nombre
A-Sustituir vocales y colocar en su lugar@
B-Contar caracteres y calculará la suma de todos los números de la cuenta
Ejemplo: Javier --> J=1 a=2 v=3 i=4 e=5 r=6 --> 1+2+3+4+5+6 = 21
C-Con el resultado de la suma del apartado B teneis que decir si pertenece a la serie de Fibonacci
*/


public class Principal {
    
    static String nombre;
    
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Introduce un nombre");
        Scanner s = new Scanner(System.in);
        nombre = s.nextLine();
        
        SustituirVocales sv = new SustituirVocales(nombre);
        Suma suma = new Suma(nombre);
        Fibonacci f = new Fibonacci();
        sv.start();
        sv.join();
        suma.start();
        suma.join();
        f.start();
        f.join();
    }

}
