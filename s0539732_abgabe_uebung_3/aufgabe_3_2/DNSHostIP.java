import java.net.UnknownHostException;

/**
 * Sven Liebig<br>
 * s0539732<br>
 * <br>
 * Verteilte Systeme SS15<br>
 * <br>
 * Aufgabe 3.2<br><br>
 * 
 * Dieses Programm stellt eine Verbindung zur der Adresse,
 * welche ueber die Programmargumente uebergeben wurde, her.
 * Die Programmargumente werden auf ihre laenge ueberprueft
 * und danach wird eine Verbindung hergestellt. Ist diese
 * Verbindung erfolgreich wird der Name und die IP-Adresse
 * der Verbindung auf der Konsole ausgegeben.
 * Falls nicht wird das Programm beendet.
 * 
 */
public class DNSHostIP {
	
	public static void main(String[] args) {
		System.out.println("\n - Programmstart -\n");
		if(checkArguments(args)) {
			try {
				System.out.println("Es wird zur Host Addresse " + args[0] + " verbunden...");
				UDPClient client = new UDPClient(args[0]);
				System.out.println("Der Host Name lautet: " + client.getHostName());
				System.out.println("Die IP-Adresse lautet: " + client.getIpAdresse());
	        } catch (UnknownHostException e) {
	        	System.out.println("Host Adresse konnte leider nicht gefunden werden.");
	        	System.out.println(e.getStackTrace());
	        }
		}
        System.out.println("\n - Programmende -\n");
    }
	
	/**Diese Funktion ueberprueft die laenge der Programmargumente .
	 * 
	 * @param args Die Programmargumente.
	 * @return True wenn die laenge der Programmargumente nicht 0 ist.
	 */
	private static boolean checkArguments(String[] args) {
		if (args.length != 1) {
            System.out.println("Nutzung: java DNSHostIP <hostname>");
            System.out.println("Der Hostname wurde beim Aufruf des Programms vergessen.");
            return false;
		} else {
			return true;
		}
	}
}
