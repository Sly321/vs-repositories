import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Dieses Programm dient der Verbindung zu einem Server als Client.
 * Es koennen Nachrichten an den Server geschickt werden und Nachrichten
 * empfangen werden.
 */
public class UDPClient_main 
{
	public static void main(String[] args) 
	{
		boolean clientOn = true;
		
		UDPClient client;
		try 
		{
			client = new UDPClient("localhost", 6666);
			
			while(clientOn) 
			{
				byte[] nachricht = Eingabe.getDatagramm();
	            try 
	            {
	            	client.sendeNachricht(nachricht);
	            }
	            catch(IOException e)
	            {
	            	System.out.println("Konnte nachricht nicht senden.");
	            	e.printStackTrace();
	            	clientOn = false;
	            }
	            catch(SocketTimeoutException e)
	            {
	            	System.out.println("Timeout der Verbindung.");
	            	e.printStackTrace();
	            	clientOn = false;
	            }
	            
	            try  
	            {
	                client.nachrichtEmpfangen();
	            }
	            catch(IOException e) {
	                System.out.println("Timeout.");
	                clientOn = false;
	            }
	            client.closeSocket();
			}
			
		} 
		catch (UnknownHostException e)
		{
			System.out.println("Konnte host nicht erreichen.");
			e.printStackTrace();
		}
		catch (SocketException e) 
		{
			System.out.println("Konnte Socket nicht erstellen.");
			e.printStackTrace();
		}
    } 
}
