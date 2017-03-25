/**
 * Created by ivan on 3/21/2017.
 */
public class BroadcastAgent {


    private BroadcastSystem system;

    public BroadcastAgent(BroadcastSystem system)
    {
        this.system = system;
    }
    public void Broadcast(String message)
    {
        system.enqueue(message);
    }

    public void receive()
    {

    }

    public BroadcastSystem getSystem()
    {
        return this.system;
    }




}
