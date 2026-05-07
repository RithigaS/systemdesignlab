import java.util.HashMap;

public class RedisDemo {

    // Fake Redis cache using HashMap
    static HashMap<String, String> cache = new HashMap<>();

    public static void main(String[] args) {

        String key = "user1";

        // Check if data exists
        if (cache.containsKey(key)) {

            System.out.println("CACHE HIT");
            System.out.println(cache.get(key));

        } else {

            System.out.println("CACHE MISS");

            // Simulated database value
            String value = "User data from DB";

            // Store in cache
            cache.put(key, value);

            System.out.println(value);
        }
    }
}
