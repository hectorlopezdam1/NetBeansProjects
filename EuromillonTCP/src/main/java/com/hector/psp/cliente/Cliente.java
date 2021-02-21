

package com.hector.psp.cliente;

import com.hector.psp.boleto.Boleto;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * @author HectorLopez
 */
public class Cliente {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Socket cliente = new Socket("localhost", 6221);
        System.out.println("EUROMILLON \nElige 5 numeros del 1 al 45(incluidos):");
        Scanner scan = new Scanner(System.in);
        DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
        int[] numeros = new int[7];
        for(int i = 0; i < 7; i++){
            if(i == 5)
                System.out.println("Ahora elige dos estrellas, del 1 al 11:");
            dos.writeInt(scan.nextInt());
        }
        System.out.println("Boleto enviado");
        
        ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
        Boleto boleto = (Boleto) ois.readObject();
        System.out.println("Objeto boleto recibido:\n" + boleto.toString());
        
        dos.close();
        cliente.close();
    }

}
