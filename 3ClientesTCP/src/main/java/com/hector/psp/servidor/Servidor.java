/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.psp.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author hecti
 */
public class Servidor {
    
    public static void main(String[] args) throws IOException {
        
        ServerSocket servidor = new ServerSocket(6010);
        System.out.println("SERVIDOR INICIADO");
        for(int i = 0; i < 3; i++){
            Socket cliente = new Socket();
            cliente = servidor.accept();
            HiloServidor hiloServidor = new HiloServidor(cliente);
            hiloServidor.start();
        }
        
    }
    
}
