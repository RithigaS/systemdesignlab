import java.util.LinkedList;
import java.util.Queue;

public class Producer {

    // Shared queue (Topic)
    static Queue<String> queue = new LinkedList<>();

    // Send message
    static void send(String msg) {

        queue.add(msg);

        System.out.println("Produced: " + msg);
    }

    public static void main(String[] args) {

        send("Order 1");
        send("Order 2");
        send("Order 3");

        // Call consumer
        Consumer.receive(queue);
    }
}
