/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.psp.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hecti
 */
public class HiloServidor extends Thread {
    DataInputStream dis;
    DataOutputStream dos;
    Socket socket = null;
    private int acumulador = 0;
    private int total = 0;

    public HiloServidor(Socket s) throws IOException {
        socket = s;
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
    }
    
    public void run(){
        while(true){
            try {
                int numero = dis.readInt();
                total += numero;
                acumulador++;
                System.out.println(numero);
                if(numero == 0)
                    break;
            } catch (IOException ex) {
                Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int media = total / (acumulador - 1);
        System.out.println("La media es: " + media);
    }
    
}
