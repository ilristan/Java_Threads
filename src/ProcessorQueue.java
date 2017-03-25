import java.util.LinkedList;

public class ProcessorQueue {

        private LinkedList<String> queue = new LinkedList<String>();

        public void enqueue(String element) {
            queue.addLast(element);
        }

        public String dequeue() {
            return queue.pop();
        }

        public Boolean isEmpty() {
            return !queue.isEmpty();
        }

    }
