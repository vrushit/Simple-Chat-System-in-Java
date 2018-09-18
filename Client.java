// Client Side Code
//Java program to illustrate Client side 
// Implementation using DatagramSocket 
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 
import java.net.SocketException; 
  
public class Client
{ 
    public static void main(String args[]) throws IOException 
    { 
        Scanner sc = new Scanner(System.in); 
  
        
        DatagramSocket ds = new DatagramSocket(); 
        DatagramSocket ds1 = new DatagramSocket(1235); 
        DatagramPacket DpReceive = null; 
        InetAddress ip = InetAddress.getLocalHost(); 
        byte[] receive = new byte[65535]; 
        byte buf[] = null; 
 
        while (true) 
        { 
            String inp = sc.nextLine(); 
  
            buf = inp.getBytes(); 
  
         
            DatagramPacket DpSend = 
                  new DatagramPacket(buf, buf.length, ip, 1234); 
  
          
            ds.send(DpSend); 
             if (inp.equals("exit")) 
                break; 
             receive = new byte[65535];
        
  
       
            DpReceive = new DatagramPacket(receive, receive.length);
            ds1.receive(DpReceive); 
                
            System.out.println(); 
            System.out.println("Server:-" + data(receive));
            System.out.println(); 
        
        } 
    } 
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
