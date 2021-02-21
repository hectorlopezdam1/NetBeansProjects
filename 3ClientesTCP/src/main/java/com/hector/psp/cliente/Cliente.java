/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.psp.cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author hecti
 */
public class Cliente {
    
    public static void main(String[] args) throws IOException {
        
        Socket cliente = new Socket("localhost", 6010);
        System.out.println("INTRODUCE NUMEROS ENTEROS, CUANDO ACABES INTRODUCE '0')");
        
        DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
        
        Scanner scan = new Scanner(System.in);
        while(true){
            int numero = scan.nextInt();
            dos.writeInt(numero);
            if(numero == 0){
                break;
            }
        }
        
    }
    
}
