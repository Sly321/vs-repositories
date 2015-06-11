import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 * This class is using a socket to create a server.
 * Clients can contact the server by the given port,
 * the server will answer the clients with their message
 * back. The server has a timeout (30 seconds default)
 * after the timeout the server closed and the socketport
 * is set free for other programs.
 */
public class UDPServer
{
	/** The size of the messages that can the Server handle */
	private int packetsize = 1000;
	/** The port where the server is reachable */
	private int port;
	/** The socket to communicate with client */
	private DatagramSocket socket;

	/**
	 * Contructor for the UDPServer, its building the Socket and throws
	 * an Exception if something fails. Server timeout after 30 seconds.
	 * @param _port the port where the server is reachable
	 * @throws SocketException is thrown when the socket initiation fails
	 */
	public UDPServer(int _port) throws SocketException
	{
		port = _port;
    	socket = new DatagramSocket(port);
    	socket.setSoTimeout(30000);
    	System.out.println("Der Server steht nun bereit unter dem Port " + port + ".");
    	System.out.println("Nach 30s ohne Daten erhalten zu haben wird der Socket geschlossen.");
	}

	/**
	 * Contructor for the UDPServer, its building the Socket and throws
	 * an Exception if something fails. Server timeout can be set manually.
	 * @param _port the port where the server is reachable
	 * @param _timeout the time in ms the server waits for a request
	 * @throws SocketException is thrown when the socket initiation fails
	 */
	public UDPServer(int _port, int _timeout) throws SocketException
	{
		port = _port;
    	socket = new DatagramSocket(port);
    	socket.setSoTimeout(_timeout);
    	System.out.println("Der Server steht nun bereit unter dem Port " + port + ".");
    	System.out.println("Nach " + _timeout/1000 + "Sekunden ohne Daten erhalten zu haben wird der Socket geschlossen.");
	}

	/**
	 * Waiting for receiving a message and sending the message back to the client where it came from.
	 * @throws SocketTimeoutException is thrown if no message is received after the given timeout
	 * @throws IOException is thrown if there is a problem by reading or sending the message
	 */
	public void getMessageAndSendBack() throws SocketTimeoutException, IOException
	{
		byte[] data = new byte[packetsize];
		DatagramPacket packet = new DatagramPacket(data, packetsize);
		socket.receive(packet);
		System.out.println(packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData()));
		socket.send(packet);
		System.out.println("Nachricht wurde erfolgreich an den Sender zurueck geschickt.");
	}

	/**
	 * Closing the socket and free the port for other programs.
	 */
	public void closeSocket()
	{
		socket.close();
	}
}
