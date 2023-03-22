package sheen.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 强密码检验器II
 * @Date 2023/1/19 12:44 上午
 * @Created by sheen
 * @Description TODO
 */
public class 强密码检验器II {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length() < 8) {
            return false;
        }

        Set<Character> set = new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for(int i = 0; i < password.length(); i++) {
            if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                a++;
            }
            if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                b++;
            }
            if(password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                c++;
            }
            if(set.contains(password.charAt(i))) {
                d++;
            }
            if(i != password.length() - 1 && password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }
        }
        return a > 0 && b > 0 && c > 0 && d > 0;

    }
}
