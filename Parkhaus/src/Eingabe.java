import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * This class is used for user-io.
 * There are several function for userinput out of the prompt.
 */
public class Eingabe 
{
    /** Buffer for reading the input from the console */
    private static BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));

    /** Default private constructor */
    private Eingabe() 
    {
    }

    /**
     * Returns text from the user input without any text based request.
     * @return the user input
     * @throws IOException If there is an IO Error
     */
    public static String getString() throws IOException
    {
        return getString("");
    }
    
    /**
     * Returns text from the user input with a text based request, based
     * on the given String parameter. The console will print out the given
     * string before asking for user input.
     * @param string the prompt for the user input
     * @return the user input
     * @throws IOException If there is an IO Error
     */
    public static String getString(String string) throws IOException
    {
        System.out.println(string);
        String text = "";
        boolean okay = false;
        while (!okay) {
            text = eingabe.readLine();
            okay = true;
        }
        return text;
    }
    
    /**
     * Returns an integer from the user input.
     * @return the user input as integer
     * @throws IOException If there is an IO Error
     */
    public static int getInt() throws IOException
    {
        return Eingabe.getInt("");
    }

    /**
     * Returns an integer from the user input with a text based request, based
     * on the given String parameter. The console will print out the given
     * string before asking for user input.
     * @param string the prompt for the user input
     * @return the user input as integer
     * @throws IOException If there is an IO Error
     */
    public static int getInt(String string) throws IOException
    {
        int value = 0;
        boolean eingabeOk = false;
        while (!eingabeOk) 
        {
            value = Integer.parseInt(getString(string));
            eingabeOk = true;
        }
        return value;
    }

    /**
     * Returns an integer from the user input with a text based request, based
     * on the given String parameter. The console will print out the given
     * string before asking for user input. The minimum and maximum values
     * of the input are fixed by the parameters.
     * @param string the prompt for the user input
     * @param min the minimum value of the input
     * @param max the maximum value of the input
     * @return the user input as integer
     * @throws IOException If there is an IO Error
     */
    public static int getInt(String string, int min, int max) throws IOException
    {
        int value = 0;
        boolean eingabeOk = false;
        while (!eingabeOk) 
        {
            value = Eingabe.getInt(string);
            eingabeOk = (min <= value && value <= max);
            if (!eingabeOk)
            	System.out.println("Eingabe muss zwischen " + min + " und " + max + " liegen!");
        }
        return value;
    }

    /**
     * Returns an double from the user input.
     * @return the user input as double
     * @throws IOException If there is an IO Error
     */
    public static double getDouble() throws IOException
    {
        return Eingabe.getDouble("");
    }

    /**
     * Returns an double from the user input with a text based request, based
     * on the given String parameter. The console will print out the given
     * string before asking for user input.
     * @param string the prompt for the user input
     * @return the user input as double
     * @throws IOException If there is an IO Error
     */
    public static double getDouble(String string) throws IOException
    {
        double value = 0;
        boolean eingabeOk = false;
        while (!eingabeOk) 
        {
            try {
                value = Double.parseDouble(getString(string));
                eingabeOk = true;
            } 
            catch (NumberFormatException nfe) {
            }
        }
        return value;
    }

    /**
     * Returns an dobule from the user input with a text based request, based
     * on the given String parameter. The console will print out the given
     * string before asking for user input. The minimum and maximum values
     * of the input are fixed by the parameters.
     * @param string the prompt for the user input
     * @param min the minimum value of the input
     * @param max the maximum value of the input
     * @return the user input as double
     * @throws IOException If there is an IO Error
     */
    public static double getDouble(String string, double min, double max) throws IOException
    {
        double value = 0;
        boolean eingabeOk = false;
        while (!eingabeOk) 
        {
            value = Eingabe.getDouble(string);
            eingabeOk = (min <= value && value <= max);
        }
        return value;
    }
}
