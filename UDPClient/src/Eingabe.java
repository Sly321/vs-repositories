import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Eingabe 
{

    private static BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));

    private Eingabe() {
    }

    public static String getText() {
        return text("");
    }
    
    public static String text(String string) {
        System.out.print(string);
        String text = "";
        boolean okay = false;
        while (!okay) {
            try  {
                text = eingabe.readLine();
                okay = true;
            } 
            catch (IOException ioe) {
            }
        }
        return text;
    }

    public static String getString() {
        String text = "";
        boolean okay = false;
        while (!okay) {
            try {
                text = eingabe.readLine();
                okay = true;
            } 
            catch (IOException ioe) {
            }
        }
        return text;
    }
    
    public static byte[] getDatagramm()
    {
        System.out.println("Bitte geben Sie eine Nachricht ein.");
        String tmp = "";
        tmp = getString();
        return tmp.getBytes();
    }
}

