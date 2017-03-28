public class TokenRingAgent extends Thread {

    private TokenRing tokenRing;
    private DSM dsm;
    private Token token;
    private int tokenid;
    private boolean active;
    private int agentid;
    private int RingPredecessor;
    private int RingSuccessor;
    private boolean hasToken;


    TokenRingAgent(TokenRing tokenRing, DSM dsm, int id)
    {
        this.tokenRing = tokenRing; // we now have access to call the tokenrings methods
        this.dsm = dsm;
        this.agentid = id;
        this.hasToken = false;
        if (agentid == 9)
        {
            this.RingSuccessor = 0;
        }
        else
        {
            this.RingSuccessor = agentid + 1;
        }
    }

    public void ReceiveToken()
    {
        this.hasToken = true;
    }

    public void SendToken(Token t)
    {
        tokenRing.passToken(t, RingSuccessor);
    }


    public void run()
    {
        while (true)
        {
            if (hasToken)
            {
                hasToken = false;
                dsm.setHasToken(true);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dsm.setHasToken(false);
                SendToken(token);

            }
        }
    }


}
