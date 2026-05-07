public class ServiceCaller {

    // Count failed requests
    static int failCount = 0;

    // Circuit breaker status
    static boolean open = false;

    public static void main(String[] args) {

        // Run 5 requests
        for (int i = 1; i <= 5; i++) {

            // If circuit is open, stop service
            if (open) {
                System.out.println("Request " + i + " Blocked");
                continue;
            }

            System.out.println("Calling Service...");

            // Random success/failure
            if (Math.random() < 0.7) {

                System.out.println("Request " + i + " Failed");

                failCount++;

            } else {

                System.out.println("Request " + i + " Success");

                failCount = 0;
            }

            // Open circuit after 3 failures
            if (failCount >= 3) {

                open = true;

                System.out.println("Circuit Breaker OPEN");
            }
        }
    }
}
