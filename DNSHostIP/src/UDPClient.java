import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Die Klasse UDPClient beschaeftigt sich mit dem Verbinden zu
 * Adressen und dem Ausgeben der Adresse oder dem Namen auf der 
 * Konsole.
 */
public class UDPClient {
	
	/** Adresse des Servers **/
	private InetAddress adresse;
	
	/**Konstruktor der Klasse UDPClient, erstellt eine InetAddress
	 * Variable mit der uebergebenen Variable address.
	 * 
	 * @param die_adresse Die Addresse auf welche man zugreifen will.
	 * @throws UnknownHostException Falls die Verbindugn schieflaeuft wurd diese Exception geschmissen.
	 */
	public UDPClient(String die_adresse) throws UnknownHostException {
		adresse = InetAddress.getByName(die_adresse);
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
}
