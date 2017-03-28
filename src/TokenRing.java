public class TokenRing {

    Processor[] processors = new Processor[10]; // holds the processors
    Token token;

    TokenRing(int message)
    {
        this.token = new Token(message);
    }


    // setter for the processor array
    public void setProcessors(Processor p, int i)
    {
        processors[i] = p;
    }


    // this method passes the token to the specified successor
    public void passToken(Token token, int RingSuccessor)
    {
        processors[RingSuccessor].getTokenRingAgent().ReceiveToken();
    }

}
