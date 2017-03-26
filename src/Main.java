import java.util.Scanner;

/**
 * Created by ivan on 3/22/2017.
 */
public class Main {

    public static void main (String[] args)
    {
        TokenRing tokenRing = new TokenRing();  // creating a token ring
        Processor[] processes = new Processor[10]; // creating an array to hold the processes
        BroadcastSystem bs = new BroadcastSystem(); //creating a broadcast system
        bs.start(); // starts the broadcast system thread


        /*
          handles:
            - creating the processes
            - giving the broadcast system access to these processes
            - starting the processes
         */
        for (int i = 0; i < 10; i++)
        {
            processes[i] = new Processor(bs, i);
            bs.setProcessor(processes[i], i);
            tokenRing.setProcessors(processes[i], i);
            processes[i].start();
        }

    }
}
