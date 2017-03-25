

public class Main {

    public static void main (String[] args)
    {
        ProcessorQueue queue  = new ProcessorQueue();

        queue.enqueue("Hello 9");

        String x = queue.dequeue();
        String[] y = x.split(" ");

        System.out.println(y[1]);



        //Processor process1 = new Processor();
    }
}
