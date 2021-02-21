/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.psp.servidor;

import com.hector.psp.coche.Coche;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author hecti
 */
public class Servidor {
    
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
        
        DatagramSocket servidor = new DatagramSocket(6778);
        System.out.println("SERVIDOR INICIADO");
        byte[] recibidos = new byte[1024];
        DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
        System.out.println("Esperando paquete del cliente...");
        servidor.receive(paqRecibido);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
        ObjectInputStream in = new ObjectInputStream(bais);
        Coche coche = (Coche) in.readObject();
        
        System.out.println(paqRecibido.getPort());
        
        System.out.println("Coche recibido: " + coche.toString());
        
        
    }
    
}
