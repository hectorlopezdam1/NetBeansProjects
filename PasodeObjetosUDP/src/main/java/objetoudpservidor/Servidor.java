

package objetoudpservidor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import pojopersona.Persona;

/**
 * 
 * @author HectorLopez
 */
public class Servidor {
    
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
        
        DatagramSocket servidor = new DatagramSocket(6300);
        
        byte[] recibidos = new byte[1024];
        DatagramPacket paqueteRecibido = new DatagramPacket(recibidos, recibidos.length);
        System.out.println("Esperando paquete del cliente...");
        servidor.receive(paqueteRecibido);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
        ObjectInputStream in = new ObjectInputStream(bais);
        Persona persona = (Persona) in.readObject();
        in.close();
        
        System.out.println("Objeto recibido: " + persona);
        
        persona.setNombre("Pepito");
        persona.setEdad(33);
        
        System.out.println("Vamos a enviar el objeto: " + persona);
        
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bs);
        out.writeObject(persona);
        out.close();
        
        InetAddress direccionOrigen = paqueteRecibido.getAddress();
        int puertoOrigen = paqueteRecibido.getPort();
        byte[] bytes = bs.toByteArray();
        
        DatagramPacket paqueteEnviado = new DatagramPacket(bytes, bytes.length, direccionOrigen, puertoOrigen);
        servidor.send(paqueteEnviado);
            
        servidor.close();
        
    }

}
