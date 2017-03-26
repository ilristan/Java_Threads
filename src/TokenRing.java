/**
 * Created by ivan on 3/21/2017.
 */
public class TokenRing {

    Processor[] processors = new Processor[10]; // gives access to all processes


    public void setProcessors(Processor p, int i)
    {
        processors[i] = p;
    }

    public void passToken(Token token, int i)
    {
        processors[i].getTokenRingAgent().ReceiveToken(token);
    }


}
