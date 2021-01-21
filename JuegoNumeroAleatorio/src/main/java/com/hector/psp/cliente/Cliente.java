

package com.hector.psp.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * @author HectorLopez
 */
public class Cliente {
    
    public static void main(String[] args) throws IOException {
        
        Socket cliente = new Socket("localhost", 6000);
        
        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
        
        int aleatorio = flujoEntrada.readInt();
        System.out.println(aleatorio);
        System.out.println("Intenta adivinar el numero secreto: ");
        Scanner scan = new Scanner(System.in);
        while(true){
            int numero = scan.nextInt();
            flujoSalida.writeInt(numero);
            if(numero != aleatorio){
                System.out.println("Intentalo otra vez");
            }else{
                System.out.println(flujoEntrada.readUTF());
                flujoSalida.close();
                flujoEntrada.close();
                cliente.close();
                break;
            }
            
        }
        
        
        
    }

}