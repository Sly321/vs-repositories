import java.util.ArrayList;

/**
 * This class represents a car park where cars can drive in and drive out.
 * The car park has an amount of free car park spaces. 
 * @author Sven Liebig / s0539732
 *
 */
public class CarPark 
{
	/** Represents the free car park spaces in the car park */
    private int freeCarParkSpaces;
    /** This is a arraylist with the queue of the cars which want to drive in the car park */
    private ArrayList<Car> queue;

    /**
     * Generates a new ArrayList for the queue of the cars and setting up the freeCarParkSpaces
     * @param amountCarParkSpaces amount of the spaces in the car park that are free
     */
    public CarPark(int amountCarParkSpaces) 
    {
        freeCarParkSpaces = amountCarParkSpaces;
        queue = new ArrayList<Car>();
    }

    /**
     * Simulates that a car drives into the car park. If the car park
     * have no free spaces, the car thread will wait until there is a
     * notification from the driveOut method that free space is available
     * now.
     * @param car the car that drives in
     * @throws InterruptedException if something went wrong with the thread
     */
    public synchronized void driveIn(Car car) throws InterruptedException 
    {
        queue.add(car);
        System.out.printf("\n<-- Auto %s kommt an.", car.getLicensePlate());
        while(freeCarParkSpaces == 0 || queue.indexOf(car) > 0) {
            wait();
        }
        System.out.printf("\n<-- Auto %s faehrt ins Parkhaus.", car.getLicensePlate());
        queue.remove(car);
        freeCarParkSpaces -= 1;
        System.out.printf("\n<-- Freie Parkplaetze: %d", freeCarParkSpaces);
    }

    /**
     * Simulates that a drives out the car park. Notifies all the other threads that one
     * free space more is now available.
     * @param car The car that drives out of the car park.
     */
    public synchronized void driveOut(Car car) 
    {
        System.out.printf("\n--> Auto %s verlaesst das Parkhaus.", car.getLicensePlate());
        freeCarParkSpaces += 1;
        notifyAll();
        System.out.printf("\n--> Freie Parkplaetze: %d", freeCarParkSpaces);
    }
}
