import java.util.Base64;
import java.util.concurrent.ConcurrentHashMap;

public class P535 {
    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        // decode a String
        //byte [] barr = Base64.getDecoder().decode(encoded);

        P535 p = new P535();
        System.out.println(p.decode(p.encode("https://leetcode.com/problems/design-tinyurl")));
    }

    public String encode(String longUrl) {
        String encodeToString = Base64.getEncoder().encodeToString(longUrl.getBytes());
        map.put(encodeToString, longUrl);
        return encodeToString;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
