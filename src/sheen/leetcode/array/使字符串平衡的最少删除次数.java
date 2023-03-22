package sheen.leetcode.array;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Classname 使字符串平衡的最少删除次数
 * @Date 2023/3/6 12:48 上午
 * @Created by sheen
 * @Description TODO
 */
public class 使字符串平衡的最少删除次数 {
    public static void main(String[] args) {
        使字符串平衡的最少删除次数 s = new 使字符串平衡的最少删除次数();
        System.out.println(s.minimumDeletions("aabbaababbababaabbbaabbbbaababababbabbbababbabbaabaaabbbbbbaaabbbbabaababbaaabbbbaaabababbbaaa"));
    }
    public int minimumDeletions(String s) {
        int[] a = new int[s.length()];
        int[] b = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            if(i == 0) {
                a[i] = s.charAt(i) == 'a' ? 1 : 0;
                b[i] = s.charAt(i) == 'b' ? 1 : 0;
            }else {
                a[i] = a[i - 1] + (s.charAt(i) == 'a' ? 1 : 0);
                b[i] = b[i - 1] + (s.charAt(i) == 'b' ? 1 : 0);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++) {
            int v = 0;
            if(s.charAt(i) == 'a') {
                v = i + 1 - a[i];
            }else {
                v = i + 1 - b[i];
            }
            v += a[s.length() - 1] - a[i];
            min = Math.min(min, v);
        }

        return min;
    }
}
