import java.util.concurrent.Semaphore;

/**
 * This class represents an actions thread which works with semaphore.
 * The thread will wait until the ressource check of the semaphore is finished.
 * @author Sven Liebig / s0539732
 *
 */
public class ActionThread extends Thread 
{
	/** An obejct that represents the action that will be done */
    private final Action action;
    /** The Semaphore controls ths access of multiple processes */
    private final Semaphore semaphore;
    /** The ressource thats used for the process */
    private final int resources;
    
    /**
     * 
     * @param enterName
     * @param enterSemaphore
     * @param amountResources
     */
    public ActionThread(String enterName, Semaphore enterSemaphore, int amountResources) 
    {
        action = new Action(enterName);
        semaphore = enterSemaphore;
        resources = amountResources;
    }
    
    /**
     * Runs the threads and calculate the ressource with the semaphore.
     * After the ressource check the action will be printed and the 
     * ressource will be release.
     */
    @Override
    public void run()
    {
        try 
        {
            semaphore.acquire(resources);
            action.print();
            semaphore.release(resources);
        }
        catch (InterruptedException ex) 
        {
            System.out.printf("Fehler aufgetreten in: %s\n", action.getName());
        }
    }
}
