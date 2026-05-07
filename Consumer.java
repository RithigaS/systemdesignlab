import java.util.Queue;

public class Consumer {

    // Receive messages
    static void receive(Queue<String> queue) {

        System.out.println("\nConsumer Started\n");

        while (!queue.isEmpty()) {

            System.out.println("Consumed: " + queue.poll());
        }
    }
}
