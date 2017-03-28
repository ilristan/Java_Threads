public class Main {

    public static void main (String[] args)
    {

        TokenRing tokenRing = new TokenRing(0); //creates a token ring
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
            processes[i] = new Processor(bs, i, tokenRing);
            bs.setProcessor(processes[i], i);
            tokenRing.setProcessors(processes[i], i); //gives the token ring access to the processors
            processes[i].start();
        }

    }
}
