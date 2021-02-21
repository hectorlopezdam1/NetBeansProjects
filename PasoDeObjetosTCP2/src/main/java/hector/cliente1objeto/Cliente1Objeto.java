/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hector.cliente1objeto;

import hector.pojopersona.Persona;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 
 * @author hecti
 */
public class Cliente1Objeto{
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        String host = "localhost";
        int puerto = 6000;
        System.out.println("PROGRAMA CLIENTE INICIADO...");
        Socket cliente = new Socket(host, puerto);
        
        //Flujo de entrada para objetos
        ObjectInputStream personaEntra = new ObjectInputStream(
                cliente.getInputStream());
        
        //Se recibe un objeto
        Persona dato = (Persona) personaEntra.readObject();
        
        //Modificamos el objeto para ver como funciona
        dato.setNombre("Juan Ramos");
        dato.setEdad(80);
        
        //Flujo de salida para objetos
        ObjectOutputStream personaSale = new ObjectOutputStream(
                cliente.getOutputStream());
        
        //Se envia el objeto
        personaSale.writeObject(dato);
        System.out.println("Envio: " + dato.getNombre()
                            + "*" + dato.getEdad());
        
        //Cerramos streams y sockets
        personaEntra.close();
        personaSale.close();
        cliente.close();
        
    }

}
