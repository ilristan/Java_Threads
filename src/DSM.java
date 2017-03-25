/**
 * Created by ivan on 3/21/2017.
 */
public class DSM {

    private BroadcastSystem system;
    private LocalMemory localMem;
    private BroadcastAgent ba;



    DSM(BroadcastSystem system)
    {
        this.system = system;
        localMem = new LocalMemory();
        this.ba = new BroadcastAgent(system);

    }

    public int load(String x)
    {
        return localMem.load(x);
    }

    public void store(String x, int v)
    {
        localMem.store(x, v);
        String message = x + " " + Integer.toString(v);
        ba.Broadcast(message);
    }

}
