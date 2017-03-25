/**
 * Created by ivan on 3/21/2017.
 */
public class Processor extends Thread{

    private BroadcastSystem system;
    private DSM dsm;

    Processor(BroadcastSystem system)
    {
        this.system = system;
        dsm = new DSM(system);

    }

    public void run()
    {
        System.out.println("test");
    }
}
