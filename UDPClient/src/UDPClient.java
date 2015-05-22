import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Die Klasse UDPClient beschaeftigt sich mit dem Verbinden zu
 * Adressen und dem Ausgeben der Adresse oder dem Namen auf der 
 * Konsole.
 */
public class UDPClient {
	
	/** Adresse des Servers **/
	private InetAddress adresse;
	/** Port des Server **/
	private int port;
	/** Socket zur Kommunikation **/
	private DatagramSocket socket;
	
	/**Konstruktor der Klasse UDPClient, erstellt eine InetAddress
	 * Variable mit der uebergebenen Variable address.
	 * 
	 * @param die_adresse Die Addresse auf welche man zugreifen will.
	 * @throws UnknownHostException Falls die Verbindugn schieflaeuft wurd diese Exception geschmissen.
	 */
	public UDPClient(String die_adresse) throws UnknownHostException {
		adresse = InetAddress.getByName(die_adresse);
	}
	
	/**Konstruktor der Klasse UDPClient, erstellt eine InetAddress
	 * Variable mit der uebergebenen Variable address. Dann wird
	 * ein Socket erstellt.
	 * 
	 * @param die_adresse Die Adresse auf welche man zugreifen will.
	 * @param der_port Der Port von der Adresse auf den man zugreifen will.
	 * @throws UnknownHostException Falls die Verbindugn schieflaeuft wurd diese Exception geschmissen.
	 * @throws SocketException Falls die Socketerstellung schieflaeuft wird diese Exception geschmissen.
	 */
	public UDPClient(String die_adresse, int der_port) throws UnknownHostException, SocketException {
		adresse = InetAddress.getByName(die_adresse);
		socket = new DatagramSocket();
		port = der_port;
	}
	
	/**
	 * Gibt den Host Namen der aktuellen Verbindung ueber InetAddress zurueck.
	 * 
	 * @return Der Name der aktuellen Verbindung.
	 */
	public String getHostName() 
	{
    	return adresse.getHostName();
	}
	
	/**
	 * Gibt die Ip Adresse der aktuellen Verbindung ueber InetAddress zurueck.
	 * 
	 * @return Die Adresse der aktuellen Verbindung.
	 */
	public String getIpAdresse() 
	{
		return adresse.getHostAddress();
	}
	
	/**
	 * 
	 * @param nachricht
	 * @return
	 * @throws IOException
	 */
	public boolean sendeNachricht(byte[] nachricht) throws IOException, SocketTimeoutException 
	{
		DatagramPacket request = new DatagramPacket(nachricht, nachricht.length, adresse,port);
		socket.send(request);
        socket.setSoTimeout(5000);
		return false;
	}
	
	/**
	 * 
	 * @throws SocketTimeoutException
	 */
	public void nachrichtEmpfangen() throws IOException
	{
		byte[] buffer = new byte[1000];
        DatagramPacket antwort = new DatagramPacket(buffer, buffer.length);
        socket.receive(antwort);
        System.out.println("Serverantwort: " + new String(antwort.getData()));
	}
	
	public void closeSocket() 
	{
		socket.close();
	}
}
