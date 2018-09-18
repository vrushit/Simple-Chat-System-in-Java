// Server Side Code
// Java program to illustrate Server side 
// Implementation using DatagramSocket 
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 
import java.net.SocketException; 
  
  
public class Server
{ 
    public static void main(String[] args) throws IOException 
    { 
         Scanner sc = new Scanner(System.in); 
        // Step 1 : Create a socket to listen at port 1234 
        DatagramSocket ds = new DatagramSocket(1234); 
        DatagramSocket ds1 = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
        byte[] receive = new byte[65535]; 
  
        DatagramPacket DpReceive = null; 

        while (true) 
        { 
   
            DpReceive = new DatagramPacket(receive, receive.length); 
  
            ds.receive(DpReceive); 
            
            System.out.println(); 
            System.out.println("Client:-" + data(receive));
            System.out.println(); 

             String inp = sc.nextLine(); 
            buf = inp.getBytes(); 

   DatagramPacket DpSend =  new DatagramPacket(buf, buf.length, ip, 1235); 
                ds1.send(DpSend); 


                    if (data(receive).toString().equals("exit")) 
            { 
                System.out.println("Client sent bye"); 
                break; 
            } 
            receive = new byte[65535]; 
        } 

    } 
  
    // A utility method to convert the byte array 
    // data into a string representation. 
    public static StringBuilder data(byte[] a) 
    { 
        if (a == null) 
            return null; 
        StringBuilder ret = new StringBuilder(); 
        int i = 0; 
        while (a[i] != 0) 
        { 
            ret.append((char) a[i]); 
            i++; 
        } 
        return ret; 
    } 
} 
