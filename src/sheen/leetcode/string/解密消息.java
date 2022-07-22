package sheen.leetcode.string;

import java.util.Arrays;

/**
 * @Classname 解密消息
 * @Date 2022/7/3 10:35 上午
 * @Created by sheen
 * @Description TODO
 */
public class 解密消息 {
    public static void main(String[] args) {
        解密消息 s = new 解密消息();

    }
    public String decodeMessage(String key, String message) {
        int[] keys = new int [26];
        Arrays.fill(keys, -1);
        int j = 0;
        for(int i = 0 ; i < key.length(); i++) {
            if(key.charAt(i) != ' ' && keys[key.charAt(i) - 'a'] == -1) {
                keys[key.charAt(i) - 'a'] = j++;
            }
        }
        String res = "";
        for(int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == ' ') {
                res += message.charAt(i);
                continue;
            }
            res += (char)('a' + keys[message.charAt(i) - 'a']);
        }

        return res;
    }
}
