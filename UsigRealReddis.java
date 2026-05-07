import redis.clients.jedis.Jedis;

public class RedisCacheDemo {

    public static void main(String[] args) throws Exception {

        // Connect Redis server
        Jedis jedis = new Jedis("localhost", 6379);

        System.out.println("Connected: " + jedis.ping());

        String key = "user:1001";

        // Check data in Redis
        String value = jedis.get(key);

        if (value != null) {
            // Data found in cache
            System.out.println("CACHE HIT");
            System.out.println(value);
        } else {
            // Data not found, load from database
            System.out.println("CACHE MISS");

            String dbValue = "User data from database";

            // Store data in Redis for 5 seconds
            jedis.setex(key, 5, dbValue);

            System.out.println(dbValue);
        }

        jedis.close();
    }
}
