/**
 * This class extends the class thread and starts threads of cars that drive in
 * and drive out of a car park.
 *
 * @author Sven Liebig / s0539732
 *
 */
public class CarThread extends Thread
{
	  /** Represents a car which drives in the carPark */
    private Car car;
    /** Represents a carPark where car variables can drive in */
    private CarPark carPark;

    /**
     * Genererates a new car and takes the carPark parameter into an argument.
     * @param carPark The given carPark where the cars will drive in.
     */
	  public CarThread(CarPark carPark)
    {
        car = new Car();
        this.carPark = carPark;
    }

    /**
     * Starts the thread and begins the cycle of the car park.
     * The car will drive in, and the thread will sleep.
     * After that the car will drive out of the car park.
     */
    @Override
    public void run()
    {
        try
        {
        	car.parkCycle(carPark);
        }
        catch (InterruptedException e)
        {
            System.out.printf("Fehler aufgetreten.");
        }
    }
}
