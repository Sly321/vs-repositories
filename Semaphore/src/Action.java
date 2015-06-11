/**
 * This class represents an action that can be used for threads.
 * @author Sven Liebig / s0539732
 *
 */
public class Action 
{
	/** The name of the action */
    private final String name;

    /**
     * Set the name argument to the given parameter.
     * @param name the name of the action
     */
    public Action(String name) 
    {
        this.name = name;
    }
    
    /**
     * Returns the name string of the action.
     * @return the attribute name as string
     */
    public String getName() 
    {
        return this.name;
    }
    
    /**
     * Prints out that the actions is done and sets the thread to sleep.
     * @throws InterruptedException when something wents wrong with the thread
     */
    public synchronized void print() throws InterruptedException 
    {
        System.out.println(name + ": Fuehre Aktion aus.");
        Thread.sleep(1500);
    }
}
