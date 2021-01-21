

package com.hector.psp.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author HectorLopez
 */
public class HiloServidor extends Thread{

    Socket socket = null;
    DataOutputStream flujoSalida;
    DataInputStream flujoEntrada;
    int aleatorio;

    public HiloServidor(Socket cliente) throws IOException {
        
        socket = cliente;
        flujoSalida = new DataOutputStream(cliente.getOutputStream());
        flujoEntrada = new DataInputStream(cliente.getInputStream());
        
    }
    
    public void run(){
        try {
            generarAleatorioyMandarlo();
            leerNumero();
            
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generarAleatorioyMandarlo() throws IOException {
        
        Random rand = new Random();
        aleatorio = rand.nextInt(11-0) + 0;
        System.out.println("El numero secreto es: " + aleatorio);
        flujoSalida.writeInt(aleatorio);
        
    }
    private void leerNumero() throws IOException{
        while(true){
           if(flujoEntrada.readInt() == aleatorio){
                flujoSalida.writeUTF(socket.toString() + " HA ACERTADO EL NUMERO");
                flujoEntrada.close();
                flujoSalida.close();
                socket.close();
                break;
            }else{
               System.out.println(socket.toString() + "HA FALLADO: " + flujoEntrada.readInt()); 
            }
        }
    }
    
    

}
