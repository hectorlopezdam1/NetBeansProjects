/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hector.servidor1objeto;

import hector.pojopersona.Persona;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author hecti
 */
public class Servidor1Objeto {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        int numeroPuerto = 6000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept();
        
        //Se prepara un flujo de salida para objetos
        ObjectOutputStream outObjeto = new ObjectOutputStream(
                cliente.getOutputStream());
        
        //Se prepara un objeto y se envia
        Persona persona = new Persona("Juan", 20);
        outObjeto.writeObject(persona);//enviando objeto
        System.out.println("Envio: " + persona.getNombre() +
                                "*" + persona.getEdad());
        
        //Se obtiene un stream para leer objetos
        ObjectInputStream inObjeto = new ObjectInputStream
                (cliente.getInputStream());
        Persona dato = (Persona) inObjeto.readObject();
        System.out.println("Recibo: " + dato.getNombre() +
                                "*" + dato.getEdad());
        
        //Cerramos streams y sockets
        outObjeto.close();
        inObjeto.close();
        cliente.close();
        servidor.close();
        
    }

}
