import java.util.LinkedList;


public class BroadcastSystem extends Thread{

    private LinkedList<String> queue = new LinkedList<String>(); // the queue for the broadcast system
    private Processor[] processors = new Processor[10]; //array to hold all the processes

    public void enqueue(String element) {
        queue.addLast(element);
    } //adds messages to the queue

    // runs the broadcast system
    public void run()
    {
        //continuously listening
        while (true)
        {
            // sleep for 10ms to avoid popping conflicts
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!queue.isEmpty()) //check to see if something is in the queue first
            {
                String tempMessage = queue.pop(); //pops the message to send to all agents
                String[] message = tempMessage.split(" "); // produces key value pair we need

                // loops through all processes telling them to do the store
                for(int i = 0; i<10; i++)
                {
                    processors[i].getDsm().getba().receive(message[0], Integer.parseInt(message[1]));
                }
                break; // once all processes are through, break out of this infinite loop
            }
        }
    }

    // method used to set the processor array
    public void setProcessor(Processor p, int i)
    {
        processors[i] = p;
    }
}




