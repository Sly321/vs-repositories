import java.io.IOException;
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
			client = new UDPClient("localhost", 9999);
			
			while(clientOn) 
			{
				byte[] nachricht = Eingabe.getDatagramm();
	            try 
	            {
	            	client.sendeNachricht(nachricht);
	            }
	            catch(SocketTimeoutException e)
	            {
	            	System.out.println("Timeout der Verbindung zu " + client.getIpAdresse() + ".");
	            	e.printStackTrace();
	            	clientOn = false;
	            }
	            catch(IOException e)
	            {
	            	System.out.println("Konnte nachricht nicht an " + client.getIpAdresse() + " senden.");
	            	e.printStackTrace();
	            	clientOn = false;
	            }
	            
	            try  
	            {
	                client.nachrichtEmpfangen();
	            }
	            catch(SocketTimeoutException e)
	            {
	            	System.out.println("Timeout der Verbindung zu " + client.getIpAdresse() + ".");
	            	e.printStackTrace();
	            	clientOn = false;
	            }
	            catch(IOException e) 
	            {
	                System.out.println("Nachricht konnte nicht von " + client.getIpAdresse() + " empfangen werden.");
	                e.printStackTrace();
	                clientOn = false;
	            }
			}
			client.closeSocket();
			
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
