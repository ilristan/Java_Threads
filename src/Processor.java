/**
 * Created by ivan on 3/21/2017.
 */
public class Processor extends Thread{

    private BroadcastSystem system;
    private DSM dsm;
    private int pid;
    private boolean f = false;
    Processor(BroadcastSystem system, int pid)
    {
        this.system = system;
        this.pid = pid;
        dsm = new DSM(system);

    }

    public void run()
    {
        for(int i = 0; i <10 ; i++)
        {
            dsm.store("flag"+Integer.toString(i),-1);
        }
        for(int i = 0; i <9 ; i++)
        {
            dsm.store("turn"+Integer.toString(i),-1);
        }

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
            }
        }

        System.out.println("im in the critical section " + pid);
        dsm.store("flag"+pid,-1);  //flag[processID] = -1;
        System.out.println("im exiting the critical section " + pid);
    }

    public int getPid()
    {
        return this.pid;
    }

    public DSM getDsm()
    {
        return this.dsm;
    }
}
