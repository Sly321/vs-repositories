import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Eingabe 
{
    /** Buffer for reading the input from the console */
    private static BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));

    /** Default private constructor */
    private Eingabe() {
    }

    /**
     * Returns text from the user input without any text based request.
     * @return the user input
     */
    public static String getText() {
        return text("");
    }
    
    /**
     * Returns text from the user input with a text based request, based
     * on the given String parameter. The console will print out the given
     * string before asking for user input.
     * @param string the prompt for the user input
     * @return the user input
     */
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

    /**
     * Returns a byte array of an user input. 
     * Prompt will printed out before the user input.
     * @return the user input as byte array
     */
    public static byte[] getDatagramm()
    {
        String tmp = text("Bitte geben Sie eine Nachricht ein.");
        return tmp.getBytes();
    }
}

