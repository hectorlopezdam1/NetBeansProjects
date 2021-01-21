

package com.hector.psp.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author HectorLopez
 */
public class Servidor {
    
    public static void main(String[] args) throws IOException {
        
        ServerSocket servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciado...");
        int count = 0;
        while(true) {
            
            Socket cliente = new Socket();
            cliente = servidor.accept();
            count++;
            if(count >= 3){
                cliente.close();
            }
            HiloServidor hiloServidor = new HiloServidor(cliente);
            hiloServidor.start();
            
        }        
    }

}
