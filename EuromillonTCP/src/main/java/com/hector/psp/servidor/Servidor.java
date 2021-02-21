

package com.hector.psp.servidor;

import com.hector.psp.boleto.Boleto;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author HectorLopez
 */
public class Servidor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket servidor = new ServerSocket(6221);
        System.out.println("Iniciando servidor...");
        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado");
        int[] numeros = new int[7];
        
        DataInputStream dis = new DataInputStream(cliente.getInputStream());
       
        System.out.print("Numeros: ");
        for(int i = 0; i < 7; i++){
            if(i == 5)
                System.out.print("Estrellas: ");
            numeros[i] = dis.readInt();
            System.out.print(numeros[i] + " ");
        }
        Boleto boleto = new Boleto(numeros);
        System.out.println("\nSe va a enviar objeto boleto:\n" + boleto.toString());
        ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
        oos.writeObject(boleto);
        
        oos.close();
        dis.close();
        cliente.close();
        servidor.close();
       
    }
    
}
