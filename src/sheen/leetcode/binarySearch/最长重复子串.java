package sheen.leetcode.binarySearch;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Classname 最长重复子串
 * @Date 2021/12/23 12:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最长重复子串 {
    public static void main(String[] args) {
        最长重复子串 s = new 最长重复子串();
        System.out.println(s.longestDupSubstring("banana"));
    }
    public String longestDupSubstring(String s) {
        int right = s.length() - 1;
        int left = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(check(s, mid)) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        if(right >= 1 && right <= s.length() - 1) {
            Set<String> set = new HashSet<>();
            for(int i = 0; i <= s.length() - right; i++) {
                String str = s.substring(i, i + right);
                if(set.contains(str)) {
                    return str;
                }
                set.add(str);
            }
        }
        return "";
    }

    Random random = new Random();
    // 生成两个进制
    int a1 = random.nextInt(75) + 26;
    int a2 = random.nextInt(75) + 26;
    // 生成两个模
    int mod1 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
    int mod2 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
    public boolean check(String s, int len) {
        Set<Long> set = new HashSet<>();
        long h1 = 0;
        long h2 = 0;
        for(int i = 0; i <= s.length() - len; i ++) {
            if(i == 0) {
                int index = i;
                for(int j = len - 1; j >= 0; j--) {
                    h1 = (h1 + (s.charAt(index) - 'a') * pow(a1, j, mod1) % mod1) % mod1 ;
                    h2 = (h2 + (s.charAt(index) - 'a') * pow(a2, j, mod2) % mod2) % mod2 ;
                    if(h1 < 0) {
                        h1 += mod1;
                    }
                    if(h2 < 0) {
                        h2 += mod2;
                    }
                    index++;
                }
                long value = h1 * mod2 + h2;
                set.add(value);
                continue;
            }
            h1 = (h1 * a1 % mod1 - (s.charAt(i - 1) - 'a') * pow(a1, len, mod1) + (s.charAt(i + len - 1) - 'a')) % mod1;
            h2 = (h2 * a2 % mod2 - (s.charAt(i - 1) - 'a') * pow(a2, len, mod2) + (s.charAt(i + len - 1) - 'a')) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }
            long num = h1 * mod2 + h2;
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }


    public long pow(long a, int b, int mod) {
        if(b == 1) return a;
        if(b == 0) return 1;
        boolean flag = b % 2 != 0;
        long res = pow(a, b / 2, mod) % mod;
        return (res * res) % mod * (flag ? a : 1) % mod;
    }
}
