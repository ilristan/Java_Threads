

public class Main {

    public static void main (String[] args)
    {
        ProcessorQueue queue  = new ProcessorQueue();

        queue.enqueue("Hello 9");
        String currentProcessor = queue.dequeue();
        String[] turn = currentProcessor.split(" ");

        System.out.println(turn[1]);



        //Processor process1 = new Processor();
    }
}
