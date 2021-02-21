

package objetoudpcliente;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import pojopersona.Persona;

/**
 * 
 * @author HectorLopez
 */
public class Cliente {
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        
        DatagramSocket cliente = new DatagramSocket();
        
        
        byte[] recibidos = new byte[1024];
        
        Persona persona = new Persona("Héctor", 21);
        
        System.out.println("Vamos a enviar el objeto: " + persona);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(persona);
        out.close();
        byte[] bytes = baos.toByteArray();
        InetAddress direccionCliente = InetAddress.getLocalHost();
        DatagramPacket paqueteEnviado = new DatagramPacket(bytes, bytes.length, direccionCliente, 6300);
        cliente.send(paqueteEnviado);
        
        DatagramPacket paqueteRecibido = new DatagramPacket(recibidos, recibidos.length);
        cliente.receive(paqueteRecibido);

        ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
        ObjectInputStream in = new ObjectInputStream(bais);
        persona = (Persona) in.readObject();
        in.close();
            
        System.out.println("Objeto modificado recibido: " + persona.toString());
        
        cliente.close();
        
    }

}
