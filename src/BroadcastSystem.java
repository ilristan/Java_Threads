import java.util.LinkedList;

public class BroadcastSystem extends ProcessorQueue{

    private LinkedList<String> queue = new LinkedList<String>();

    private Processor[] processors = new Processor[10];

    public void setProcessor(Processor p, int i)
    {
        processors[i] = p;
    }



}




