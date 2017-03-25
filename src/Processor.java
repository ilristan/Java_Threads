/**
 * Created by ivan on 3/21/2017.
 */
public class Processor extends Thread{

    private BroadcastSystem system;
    private DSM dsm;
    private int pid;
    Processor(BroadcastSystem system, int pid)
    {
        this.system = system;
        this.pid = pid;
        dsm = new DSM(system);

    }

    public void run()
    {
        System.out.println("test");
    }
}
