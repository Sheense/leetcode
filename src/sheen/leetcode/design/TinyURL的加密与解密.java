package sheen.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname TinyURL的加密与解密
 * @Date 2022/6/29 12:18 上午
 * @Created by sheen
 * @Description TODO
 */
public class TinyURL的加密与解密 {
    public static class Codec {

        private Map<String, String > en = new HashMap<>();
        private Map<String, String> de = new HashMap<>();
        private int i = 1;
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if(en.containsKey(longUrl)) {
                return en.get(longUrl);
            }
            i++;
            en.put(longUrl, "https://" + i);
            de.put( "https://" + i, longUrl);
            return "https://" + i;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return de.get(shortUrl);
        }
    }
}
