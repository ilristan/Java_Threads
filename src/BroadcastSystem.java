import java.util.LinkedList;


public class BroadcastSystem extends Thread{

    private LinkedList<String> queue = new LinkedList<String>();

    public void enqueue(String element) {
        queue.addLast(element);
    }

    public String dequeue() {
        return queue.pop();
    }

    public Boolean isEmpty() {
        return !queue.isEmpty();
    }

    private Processor[] processors = new Processor[10];


    // runs the broadcast system
    public void run()
    {
        // continuously listening
        while (true)
        {
            if (!queue.isEmpty())
            {
                String tempMessage = queue.pop(); //pops the message to send to all agents
                String[] message = tempMessage.split(" ");

                for(int i = 0; i<10; i++)
                {
                    processors[i].getDsm().store(message[0], Integer.parseInt(message[1])); //tells all agents to do this store
                }
            }
        }
    }

    public void setProcessor(Processor p, int i)
    {
        processors[i] = p;
    }






}




