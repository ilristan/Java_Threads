public class BroadcastAgent {

    // initializes variables
    private BroadcastSystem system;
    private LocalMemory localMem;

    //constructor
    public BroadcastAgent(BroadcastSystem system, LocalMemory localMem)
    {
        this.system = system; //sets the reference to the broadcast system
        this.localMem = localMem; //sets the reference to the local memory
    }

    // method to send messages to the broadcast system
    public void Broadcast(String message)
    {
        system.enqueue(message); // adds the message to the broadcast systems queue
    }

    // method to receive stores from the broadcast system
    public void receive(String x, int v)
    {
        localMem.store(x, v); // stores the message from the broadcast system to its localMem
    }

    // getter for the broadcast system
    public BroadcastSystem getSystem()
    {
        return this.system; // returns the system
    }





}
