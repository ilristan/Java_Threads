public class Main {

    public static void main (String[] args)
    {
        BroadcastSystem queue  = new BroadcastSystem();

        queue.enqueue("Hello 9");
        String currentProcessor = queue.dequeue();
        String[] turn = currentProcessor.split(" ");

        System.out.println(turn[1]);

    }
}
