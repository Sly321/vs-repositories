/**
 * This class represents a car with a license plate.
 *
 * @author Sven Liebig / s0539732
 *
 */
public class Car
{
	/** The licensePlate of the car to distinguish the cars */
    private String licensePlate;

    /**
     * Creates the licensePlate of a car with a random string between 0 and 999.
     */
    public Car()
    {
    	licensePlate = RandomNumbers.randomString(0, 999);
    }

    /**
     * Returns the license plate of the cars.
     * @return string license plate
     */
    public String getLicensePlate()
    {
        return licensePlate;
    }

    /**
     * Drives an car into the car park and drive in and out after some waiting time.
     * @param carPark the car park where the car drives in
     * @throws InterruptedException if there is a thread error
     */
    public void parkCycle(CarPark carPark) throws InterruptedException
    {
    	  carPark.driveIn(this);
        Thread.sleep(RandomNumbers.randomInteger(250, 1000));
        carPark.driveOut(this);
    }
}
