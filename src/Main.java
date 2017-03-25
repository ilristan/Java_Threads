/**
 * Created by ivan on 3/22/2017.
 */
public class Main {

    public static void main (String[] args)
    {
        BroadcastSystem BS = new BroadcastSystem();



        Processor p1 = new Processor();
        Processor p2 = new Processor();
        Processor p3 = new Processor();
        Processor p4 = new Processor();
        Processor p5 = new Processor();
        Processor p6 = new Processor();
        Processor p7 = new Processor();
        Processor p8 = new Processor();
        Processor p9 = new Processor();
        Processor p10 = new Processor();

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
