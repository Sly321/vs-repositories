import java.util.concurrent.Semaphore;
/**
 * This program shows how semaphore works.
 * It will run 5 threads but the first thread starts alone,
 * after him 2, 3, 4 are executed and as last 5 is executed.
 * 
 * @author Sven Liebig / s0539732
 *
 */
public class SemaphoreMain 
{

    public static void main(String[] args) 
    {
        Semaphore semaphore = new Semaphore(3);
     
        ActionThread a1 = new ActionThread("A1", semaphore, 3);   
        ActionThread a2 = new ActionThread("A2", semaphore, 1); 
        ActionThread a3 = new ActionThread("A3", semaphore, 1); 
        ActionThread a4 = new ActionThread("A4", semaphore, 1);      
        ActionThread a5 = new ActionThread("A5", semaphore, 3);
        
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }
    
}

