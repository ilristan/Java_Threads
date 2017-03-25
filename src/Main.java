/**
 * Created by ivan on 3/22/2017.
 */
public class Main {

    public static void main (String[] args)
    {
        BroadcastSystem bs = new BroadcastSystem(); //creating a broadcast system

        // creating 10 processes
        Processor p0 = new Processor(bs,0);
        Processor p1 = new Processor(bs,1);
        Processor p2 = new Processor(bs,2);
        Processor p3 = new Processor(bs,3);
        Processor p4 = new Processor(bs,4);
        Processor p5 = new Processor(bs,5);
        Processor p6 = new Processor(bs,6);
        Processor p7 = new Processor(bs,7);
        Processor p8 = new Processor(bs,8);
        Processor p9 = new Processor(bs,9);

        //providing bs with access to the processes
        bs.setProcessor(p0,0);
        bs.setProcessor(p1,1);
        bs.setProcessor(p2,2);
        bs.setProcessor(p3,3);
        bs.setProcessor(p4,4);
        bs.setProcessor(p5,5);
        bs.setProcessor(p6,6);
        bs.setProcessor(p7,7);
        bs.setProcessor(p8,8);
        bs.setProcessor(p9,9);

        // starting all 10 processes
        p0.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();
        p9.start();
    }
}
