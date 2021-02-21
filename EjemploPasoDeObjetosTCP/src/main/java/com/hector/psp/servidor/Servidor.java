/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.psp.servidor;

import com.hector.psp.coche.Coche;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author hecti
 */
public class Servidor {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        ServerSocket servidor = new ServerSocket(6005);
        Socket cliente = servidor.accept();
        
        ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
        Coche coche = (Coche) in.readObject();
        System.out.println("Coche recibido: " + coche.toString());
        
        cliente.close();
        servidor.close();
        
    }
    
}
