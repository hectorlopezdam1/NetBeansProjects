/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.psp.cliente;

import com.hector.psp.coche.Coche;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author hecti
 */
public class Cliente {
    
    public static void main(String[] args) throws IOException {
        
        Socket cliente = new Socket("localhost", 6005);
        
        System.out.println("Por favor, introduce los datos del coche (matricula, modelo, marca, caballos):");
        Scanner s = new Scanner(System.in);
        String matricula = s.nextLine();
        String modelo = s.nextLine();
        String marca = s.nextLine();
        int cv = s.nextInt();
        
        Coche coche = new Coche(matricula, modelo, marca, cv);
        System.out.println("¿Tu coche es: " + matricula + ", " + modelo + ", " + marca + ", " + cv + "?");
        String respuesta = s.next();
        
        if(respuesta.equals("si") || respuesta.equals("SI") || respuesta.equals("Si")){
            System.out.println("Enviando coche...");
            ObjectOutputStream outObject = new ObjectOutputStream(cliente.getOutputStream());
            outObject.writeObject(coche);
            outObject.close();
        }else if(respuesta.equals("no") || respuesta.equals("NO") || respuesta.equals("No")){
            System.out.println("¿Qué campo quieres cambiar?");
            while(true){
                String campo = s.next();
                switch(campo){
                    case "matricula":
                        System.out.println("Escribe nueva matricula");
                        coche.setMatricula(s.next());
                        break;
                    case "modelo":
                        System.out.println("Escribe nuevo modelo");
                        coche.setModelo(s.next());
                        break;
                    case "marca":
                        System.out.println("Escribe nueva marca");
                        coche.setMarca(s.next());
                        break;
                    case "caballos":
                        System.out.println("Escribe nuevos caballos");
                        coche.setCv(s.nextInt());
                        break;
                }
                System.out.println("¿Quieres cambiar otro campo?");
                if(s.next().equals("si")){
                    System.out.println("¿Qué campo quieres cambiar?");
                }else{
                    System.out.println("Enviando coche...");
                    ObjectOutputStream outObject = new ObjectOutputStream(cliente.getOutputStream());
                    outObject.writeObject(coche);
                    outObject.close();
                    break;
                }
            }
        }
        cliente.close();
    }
    
}
