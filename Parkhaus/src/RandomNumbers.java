import java.util.Random;

/**
 * This class is used to generated random numbers.
 * Random numbers can be generated as int, double or string output.
 * 
 * @author Sven Liebig / s0539732
 *
 */
public class RandomNumbers {

	/**
	 * This class returns a random integer between the given parameters.
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return A random integer between min and max
	 */
    public static int randomInteger(int min, int max) 
    {
        max++;
        return (int) (Math.random() * (max - min) + min);
    }

    /**
	 * This class returns a random double between the given parameters.
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return A random double between min and max
	 */
    public static double randomDouble(double min, double max) 
    {
        return (Math.random() * (max - min) + min);
    }
    
    /**
	 * This class returns a random string number between the given parameters.
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return A random number as string between min and max
	 */
    public static String randomString(int min, int max)
    {
    	Random rand = new Random();
    	return "" + (rand.nextInt((max - min) + 1) + min);
    }
}
