import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class URLShortener {

    // Base URL for shortened links
    static final String BASE_URL = "https://tinyurl.com/";

    // Characters used to generate short code
    static final String CHARSET =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Stores shortCode -> longURL
    static Map<String, String> urlMap = new ConcurrentHashMap<>();

    // Method to shorten URL
    static String shortenURL(String longUrl) {

        // Generate random 6-letter code
        String shortCode = generateCode();

        // Store in map
        urlMap.put(shortCode, longUrl);

        // Return full short URL
        return BASE_URL + shortCode;
    }

    // Method to get original URL
    static String redirect(String shortCode) {

        // Return original URL if exists
        return urlMap.getOrDefault(shortCode, "URL not found");
    }

    // Method to generate random code
    static String generateCode() {

        Random rand = new Random();
        StringBuilder code = new StringBuilder();

        // Generate 6 random characters
        for (int i = 0; i < 6; i++) {
            int index = rand.nextInt(CHARSET.length());
            code.append(CHARSET.charAt(index));
        }

        return code.toString();
    }

    public static void main(String[] args) {

        // Original long URL
        String longUrl = "https://example.com/some/long/path";

        // Create short URL
        String shortUrl = shortenURL(longUrl);

        // Display short URL
        System.out.println("Shortened URL : " + shortUrl);

        // Extract code from short URL
        String code = shortUrl.substring(BASE_URL.length());

        // Redirect to original URL
        System.out.println("Original URL  : " + redirect(code));
    }
}
