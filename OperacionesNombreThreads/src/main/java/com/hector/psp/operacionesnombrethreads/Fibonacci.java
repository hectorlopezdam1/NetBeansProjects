/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.psp.operacionesnombrethreads;

import java.util.Scanner;

/**
 *
 * @author hecti
 */
public class Fibonacci extends Thread {
    
    int numero, fibo1, fibo2, i;
    int limite = 100000000;
    
    public void run(){
        numero = Suma.resultado;
        comprobarNumero();
    }
    
    public void comprobarNumero() {	
                            
        Scanner valor=new Scanner(System.in);	    
       
        fibo1=1;
        fibo2=1;
		
        for(i=2;i<=limite;i++){
            if(numero == fibo2){
            System.out.println("\nEl numero " + numero +" se encuentra dentro de la serie de Fibonacci");
            break;
                }else if(i < limite){
                   fibo2 = fibo1 + fibo2;
                   fibo1 = fibo2 - fibo1;
                }else{
                   System.out.println("\nEl numero " + numero + " no se encuentra dentro de la serie de Fibonacci");
               }	 
	}
	
    }

    
}
