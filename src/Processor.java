import jdk.nashorn.internal.parser.TokenKind;

/**
 * Created by ivan on 3/21/2017.
 */
public class Processor extends Thread{

    // initializing variables
    private BroadcastSystem system;
    private DSM dsm;
    private int pid;
    private boolean f = false;
    private TokenRingAgent tokenRingAgent;

    // constructor
    Processor(BroadcastSystem system, int pid)
    {
        this.system = system;   // provides reference to the system for passing
        this.pid = pid; // identifies the process ID
        dsm = new DSM(system);  // creates a DSM
        this.tokenRingAgent = new TokenRingAgent(pid,dsm);
        tokenRingAgent.start();    // starts the token ring agent thread
    }

    // implementing peterson's algorithm
    public void run()
    {
        // initializes the flag values to -1 to prevent null pointer errors in the for loop (2 down)
        for(int i = 0; i <10 ; i++)
        {
            dsm.store("flag"+Integer.toString(i),-1);
        }

        // initializes turn values to -1 to prevent null pointer errors in the for loop below
        for(int i = 0; i <9 ; i++)
        {
            dsm.store("turn"+Integer.toString(i),-1);
        }

        // peterson's algorithm
        for (int floor = 0; floor < 9; floor++) {
            dsm.store("flag"+pid,floor); //flag[processID] = floor;
            dsm.store("turn"+floor, pid);  //turn[floor] = processID;

            for (int j = 0; j < 10; j++) {
                if(dsm.load("flag"+j) >= floor && pid != j) //if (flag[j] >= floor && processID != j)
                {
                    f = true;
                }
            }
            while(f && dsm.load("turn"+floor) == pid)  //while (f && turn[floor] == processID)
            {
                System.out.println("[" + pid + "] is waiting" + " @" + floor);
                System.out.println("--");
                f = false;
                for (int j = 0; j < 10; j++) {
                    if(dsm.load("flag"+j) >= floor && pid != j) //if (flag[j] >= floor && processID != j)
                    {
                        f = true;
                    }
                }
            }
        }

        System.out.println("im in the critical section " + pid);
        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dsm.store("flag"+pid,-1);  //flag[processID] = -1;
        System.out.println("im exiting the critical section " + pid);
    }

    // getter for the process ID
    public int getPid()
    {
        return this.pid;
    }

    // getter for the DSM
    public DSM getDsm()
    {
        return this.dsm;
    }

    // getter for the token ring agent
    public TokenRingAgent getTokenRingAgent()
    {
        return this.tokenRingAgent;
    }
}
