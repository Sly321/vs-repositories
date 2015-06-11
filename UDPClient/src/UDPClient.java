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
 * Konsole. Ausserdem koennen durch einen Socket Nachrichten an
 * Server auf dieser Adresse geschickt werden, der Port dazu kann
 * default 9876 sein oder selbst im Kontruktor gewaehlt werden.
 */
public class UDPClient {
	
	/** Adresse des Servers */
	private InetAddress adresse;
	/** Port des Server */
	private int port;
	/** Socket zur Kommunikation */
	private DatagramSocket socket;
	/** Groesse des Byte Arrays */
	private int messageLength;
	
	/**
	 * Konstruktor der Klasse UDPClient, erstellt eine InetAddress
	 * Variable mit der uebergebenen Variable address. Dann wird ein
	 * Socket erstellt.
	 * @param die_adresse Die Addresse auf welche man zugreifen will.
	 * @throws UnknownHostException Falls die Verbindugn schieflaeuft wurd diese Exception geschmissen.
	 * @throws SocketException Falls etwas mit der Socket Erstellung schieflaeuft wird diese Exception geschmissen.
	 */
	public UDPClient(String die_adresse) throws UnknownHostException, SocketException {
		adresse = InetAddress.getByName(die_adresse);
		socket = new DatagramSocket();
		port = 9876;
		messageLength = 1000;
	}
	
	/**
	 * Konstruktor der Klasse UDPClient, erstellt eine InetAddress
	 * Variable mit der uebergebenen Variable address. Dann wird
	 * ein Socket erstellt und der Port definiert.
	 * @param die_adresse Die Adresse auf welche man zugreifen will.
	 * @param der_port Der Port von der Adresse auf den man zugreifen will.
	 * @throws UnknownHostException Falls die Verbindugn schieflaeuft wurd diese Exception geschmissen.
	 * @throws SocketException Falls die Socketerstellung schieflaeuft wird diese Exception geschmissen.
	 */
	public UDPClient(String die_adresse, int der_port) throws UnknownHostException, SocketException {
		adresse = InetAddress.getByName(die_adresse);
		socket = new DatagramSocket();
		port = der_port;
		messageLength = 1000;
	}

	/**
	 * Konstruktor der Klasse UDPClient, erstellt eine InetAddress
	 * Variable mit der uebergebenen Variable address. Dann wird
	 * ein Socket erstellt und der Port definiert. Die laenge des
	 * Byte Arrays ist die maximale groesse der zu uebertragenden
	 * Nachricht.
	 * @param die_adresse Die Adresse auf welche man zugreifen will.
	 * @param der_port Der Port von der Adresse auf den man zugreifen will.
	 * @param die_msgLength Die laenge des Byte Arrays fuer die nachrichtenuebertragung.
	 * @throws UnknownHostException Falls die Verbindugn schieflaeuft wurd diese Exception geschmissen.
	 * @throws SocketException Falls die Socketerstellung schieflaeuft wird diese Exception geschmissen.
	 */
	public UDPClient(String die_adresse, int der_port, int die_msgLength) throws UnknownHostException, SocketException {
		adresse = InetAddress.getByName(die_adresse);
		socket = new DatagramSocket();
		port = der_port;
		messageLength = die_msgLength;
	}
	
	/**
	 * Gibt den Host Namen der aktuellen Verbindung ueber InetAddress zurueck.
	 * @return Der Name der aktuellen Verbindung.
	 */
	public String getHostName() 
	{
    	return adresse.getHostName();
	}
	
	/**
	 * Gibt die Ip Adresse der aktuellen Verbindung ueber InetAddress zurueck.
	 * @return Die Adresse der aktuellen Verbindung.
	 */
	public String getIpAdresse() 
	{
		return adresse.getHostAddress();
	}
	
	/**
	 * Diese Funktion sendet eine Nachricht an die in der Klasse gegebenen Adresse und Port.
	 * @param nachricht Die Nachricht welche gesendet wird.
	 * @throws IOException Wird geschmissen falls es Probleme mit der Anfrage gibt.
	 * @throws SocketTimeoutException Nach 5 Sekunden ohne Verbindung wird diese Exception geschmissen.
	 */
	public void sendeNachricht(byte[] nachricht) throws IOException, SocketTimeoutException 
	{
		DatagramPacket request = new DatagramPacket(nachricht, nachricht.length, adresse,port);
		socket.send(request);
        socket.setSoTimeout(5000);
	}
	
	/**
	 * Wartet auf eine Nachricht vom Server.
	 * @throws IOException Wird geschmissen falls die uebertragung schief laeuft.
	 */
	public void nachrichtEmpfangen() throws IOException
	{
		byte[] buffer = new byte[messageLength];
        DatagramPacket antwort = new DatagramPacket(buffer, buffer.length);
        socket.receive(antwort);
        System.out.println("Serverantwort: " + new String(antwort.getData()));
	}
	
	/**
	 * Schliesst den Socket und gibt den Port wieder fuer andere Programme frei.
	 */
	public void closeSocket() 
	{
		socket.close();
	}
}
