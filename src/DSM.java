/**
 * Created by ivan on 3/21/2017.
 */
public class DSM {

    private LocalMemory localMem = new LocalMemory();
    //private BroadcastAgent BA = new BroadcastAgent();

    public int load(String x)
    {
        return localMem.load(x);
    }

    public void store(String x, int v)
    {
        localMem.store(x, v);
        String message = x + " " + Integer.toString(v);
        //BA.broadcast(message);
    }

}
