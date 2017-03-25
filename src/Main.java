/**
 * Created by ivan on 3/22/2017.
 */
public class Main {

    public static void main (String[] args)
    {
        BroadcastSystem bs = new BroadcastSystem(); //creating a broadcast system

        // creating 10 processes
        Processor p1 = new Processor(bs);
        Processor p2 = new Processor(bs);
        Processor p3 = new Processor(bs);
        Processor p4 = new Processor(bs);
        Processor p5 = new Processor(bs);
        Processor p6 = new Processor(bs);
        Processor p7 = new Processor(bs);
        Processor p8 = new Processor(bs);
        Processor p9 = new Processor(bs);
        Processor p10 = new Processor(bs);

        // starting all 10 processes
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();
        p9.start();
        p10.start();
    }
}
