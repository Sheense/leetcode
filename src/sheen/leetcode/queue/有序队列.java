package sheen.leetcode.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Classname 有序队列
 * @Date 2022/8/3 12:23 上午
 * @Created by sheen
 * @Description TODO
 */
public class 有序队列 {
    public static void main(String[] args) {
        有序队列 s = new 有序队列();
        System.out.println(s.orderlyQueue("baaca", 3));
    }
    public String orderlyQueue(String s, int k) {
        if(k == 1) {
            String res = s;
            for(int i = 1; i < s.length(); i++) {
                s = s.substring(1) + s.substring(0, 1);
                if(res.compareTo(s) > 0) {
                    res = s;
                }
            }
            return res;
        }else {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            return String.valueOf(cs);
        }


    }
}
