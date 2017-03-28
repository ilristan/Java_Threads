public class TokenRingAgent extends Thread {

    private Token id;
    private boolean active;
    private int agentID;
    private int RingPredecessor;
    private int RingSuccessor;
    private DSM dsm;
    private TokenRing tokenRing;


    TokenRingAgent(int pid, DSM dsm, TokenRing tokenRing)
    {
        this.tokenRing = tokenRing;
        this.id = null;  // supposed to be the token id.. don't really use it yet
        this.active = false; // do we have the token? initially we don't
        this.agentID = pid; //agent id, related to its processor id
        this.dsm = dsm; // gives us access to the dsm
        if (pid == 9)
        {
            this.RingSuccessor = 0;
        }
        else
        {
            this.RingSuccessor = pid + 1;
        }
        if (pid == 0)
        {
            this.active = true;
        }
    }


    public void ReceiveToken()
    {
        this.active = true; // say we have the token
    }

    public void SendToken()
    {
        tokenRing.passToken(RingSuccessor);
    }


    public void run()
    {
        while (true)
        {
            System.out.println(agentID);
            if(active)
            {
                this.active = false;
                this.dsm.setHasToken(true); // tell the dsm that you have the token
                try {
                    sleep(100); // let the process do its work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dsm.setHasToken(false); // grab the token back
                SendToken(); // pass the token
            }
        }
    }
}
