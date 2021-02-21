/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.psp.cliente;

import com.hector.psp.coche.Coche;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author hecti
 */
public class Cliente {
    
    public static void main(String[] args) throws SocketException, IOException {
        
        DatagramSocket cliente = new DatagramSocket();
        System.out.println("CLIENTE CONECTADO");
        Scanner scan = new Scanner(System.in);
        System.out.println("Matricula:");
        String matricula = scan.nextLine();
        System.out.println("Modelo:");
        String modelo = scan.nextLine();
        System.out.println("Marca:");
        String marca = scan.nextLine();
        System.out.println("Caballos:");
        int caballos = scan.nextInt();
        
        Coche coche = new Coche(matricula, modelo, marca, caballos);
        System.out.println("Se va a enviar: " + coche.toString());
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(coche);
        out.close();
        
        byte[] bytes = baos.toByteArray();
        InetAddress direccionCliente = InetAddress.getLocalHost();
        DatagramPacket paqEnviado = new DatagramPacket(bytes, bytes.length, direccionCliente, 6778);
        cliente.send(paqEnviado);
        
    }
    
}
