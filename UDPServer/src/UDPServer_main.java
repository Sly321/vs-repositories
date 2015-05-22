import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 * This Program is for the creating a Server to get and send messages 
 * from and to clients. The Server will be reachable for 30 seconds.
 * When he gets no requests the server will close his socket after
 * this 30 seconds from the last message he got.
 */
public class UDPServer_main {

	public static void main(String[] args) {
		try 
		{
			UDPServer server = new UDPServer(9876);
		}
		catch(SocketException e)
		{
			System.out.println("Socket erstellung ist fehlgeschlagen.");
			e.printStackTrace();
		}

		boolean serverOn = true;

		while(serverOn) 
		{
	        try
	        {
	        	 server.getMessageAndSendBack();
	        }
	        catch(SocketTimeoutException e) 
			{
				System.out.println("Socket wird wegen timeout geschlossen.");
				System.out.println("SocketTimeoutException: " + e);
				server.closeSocket();
				serverOn = false;
			} 
			catch(IOException e) 
			{
				System.out.println("Nachricht konnte nicht gesendet werden.");
				System.out.println("IOException: " + e);
				server.closeSocket();
				serverOn = false;
			}
	        System.out.println("Programm beendet.");
    	}
    }
}