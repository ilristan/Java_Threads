public class TokenRing {

    Processor[] processors = new Processor[10]; // array that holds all the processors
    private Token token;
    // constructor
    TokenRing(int tokenMessage)
    {
        token = new Token(tokenMessage); // creates token for the token ring
    }

    public void setProcessors(Processor p, int i)
    {
        processors[i] = p;
        if (i == 0)
        {
            processors[i].getTokenRingAgent().ReceiveToken(); //start process 0 with the token
        }
    }

    public void passToken(int Successor)
    {
        processors[Successor].getTokenRingAgent().ReceiveToken(); // passes the token to the next process in line
    }

}
