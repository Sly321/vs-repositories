import java.io.IOException;

/**
 * This program simulate cars that drive in and out a car park.
 * The car park will have an amount of free car park spaces and
 * the new cars will not be able to enter the car park before 
 * the spaces are free. The queue of the cars is important.
 * The first car that is waiting to enter the car park is the
 * first which can enter after a free spaces is there.
 * The user can choose the amount of free spaces and the amount
 * of cars that drive into the car park.
 *  
 * @author Sven Liebig / s0539732
 *
 */
public class ParkhausMain 
{
    public static void main(String[] args)
    {
        int carParkSpaces = 0;
        int cars = 0;
        boolean inputOk = false;
        
		try 
		{
			carParkSpaces = Eingabe.getInt("Wieviele Parkplaetze soll das Parkhaus besitzen? : ", 1, 100);
			cars = Eingabe.getInt("Wieviele Autos sollen das Parkhaus befahren? : ", 1, 100);
			inputOk = true;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
        
		if (inputOk) 
		{
			CarPark carPark = new CarPark(carParkSpaces);
	        
	        for(int i = 0; i < cars; i++) 
	        {
	            CarThread auto = new CarThread(carPark);
	            auto.start();
	        }  
		}
            
    }
}
