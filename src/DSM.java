/**
 * Created by ivan on 3/21/2017.
 */
public class DSM {

    // initializes variables
    private BroadcastSystem system;
    private LocalMemory localMem;
    private BroadcastAgent ba;


    // constructor
    DSM(BroadcastSystem system)
    {
        this.system = system; //sets the reference to the broadcast system
        localMem = new LocalMemory();  // creates a local memory
        this.ba = new BroadcastAgent(system,localMem); // creates a broadcast agent

    }

    // loads the value from local memory
    public int load(String x)
    {
        return localMem.load(x);
    }

    // stores a value to local memory and broadcasts it to the broadcast system
    public void store(String x, int v)
    {
        localMem.store(x, v);   // stores to local memory
        String message = x + " " + Integer.toString(v); // converts key value pair to string for passing
        ba.Broadcast(message); // adds this string to the broadcast systems queue
    }

    // getter for the local memory
    public LocalMemory getLocalMem()
    {
        return this.localMem;
    }

    // getter for the broadcast agent
    public BroadcastAgent getba()
    {
        return this.ba;
    }
}
