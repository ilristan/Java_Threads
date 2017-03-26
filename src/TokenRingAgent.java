/**
 * Created by ivan on 3/21/2017.
 */
public class TokenRingAgent extends Thread {

    private boolean tokenAcquired = false;
    private TokenRing tokenRing;  // provides access to the token ring
    private DSM dsm;
    private Token token = new Token (-1);  // identifies what token the agent has
    private int tokenAgentID;  // identifies what process the agent belongs to
    private boolean active = false; // don't use yet...
    private int RingPredecessor;  // identifies where the token is coming from
    private int RingSuccessor;  // identifies where to pass the token

    // constructor
    TokenRingAgent(int tokenAgentID, DSM dsm)
    {
        this.tokenAgentID = tokenAgentID; // process ID
        this.dsm = dsm; // we need access to the dsm methods
        if (tokenAgentID == 0)
        {
            this.token = new Token(0);
            this.tokenAcquired = true;
        }
        setRingSuccessor(); // identifies where to pass the token to
    }

    // method for what happens when we receive the token
//    public void ReceiveToken()
//    {
//
//    }

    // method for sending the token to the successor
    public void SendToken(Token t)
    {
        System.out.println("in the sendtoken funcitn");
        tokenRing.passToken(t, RingSuccessor);
    }

    // setter for the successor
    public void setRingSuccessor()
    {
        // needs to wrap around
        if (tokenAgentID == 9)
        {
            this.RingSuccessor = 0;
        }
        else
        {
            this.RingSuccessor = tokenAgentID++;
        }
    }

    // setter for the token
    public void ReceiveToken(Token token)
    {
        this.token = token;
        tokenAcquired = true;

    }

//    public void setStahp(Boolean stahp)
//    {
//        this.stahp = stahp;
//    }

    public void run() {

        while (true)
        {
            if (tokenAcquired)
            {
                dsm.setHasToken(true);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dsm.setHasToken(false);
                tokenAcquired = false;
                System.out.println("sending token");
                SendToken(token);
                System.out.println("Heeeellllooooooo");
            }
        }
    }
}
