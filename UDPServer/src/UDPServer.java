import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class UDPServer {

	private final static int PACKETSIZE = 1000;
	private int port;
	private DatagramSocket socket;
	private boolean serverOn = true;

	public UDPServer(int _port) {
		port = _port;
	    try {
	    	socket = new DatagramSocket(port);
	    	socket.setSoTimeout(30000);
	    	System.out.println("Der Server steht nun bereit unter dem Port " + port + ".");
	    	System.out.println("Nach 30s ohne Daten erhalten zu haben wird der Socket geschlossen.");
	    } catch(SocketException se) {
	    	System.out.println(se);
	    }
	}

	public void getMessageAndSendBack()  {
		while(serverOn) {
			try {
				byte[] data = new byte[PACKETSIZE];
				DatagramPacket packet = new DatagramPacket(data, PACKETSIZE);
				socket.receive(packet);
				//Schreibe PaketInformationen aus...
				System.out.println(packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData()));
				//schicke paket wieder zurück.
				socket.send(packet);
				System.out.println("Nachricht wurde erfolgreich an den Sender zurueck geschickt.");
			} catch(SocketTimeoutException e) {
				System.out.println("Socket wird wegen timeout geschlossen");
				socket.close();
				serverOn = false;
			} catch(IOException e) {
				System.out.println("IOException: " + e);
			}
		}
	}
	
	public static void main(String[] args) {
        UDPServer server = new UDPServer(2000); //
        server.getMessageAndSendBack();
        System.out.println("Programm beendet.");
    }
}
