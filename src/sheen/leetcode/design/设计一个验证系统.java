package sheen.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 设计一个验证系统
 * @Date 2023/2/9 2:39 下午
 * @Created by sheen
 * @Description TODO
 */
public class 设计一个验证系统 {
    static class AuthenticationManager {

        private int timeToLive;
        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
        }
        private Map<String, Integer> map = new HashMap<>();

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime);
        }

        public void renew(String tokenId, int currentTime) {
            if(map.containsKey(tokenId)) {
                int time = map.get(tokenId);
                if(currentTime >= time + timeToLive) {
                    map.remove(tokenId);
                }else {
                    map.put(tokenId, currentTime);
                }

            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int res = 0;
            for(int time : map.values()) {
                if(time + timeToLive > currentTime) {
                    res++;
                }
            }
            return res;
        }
    }
}
