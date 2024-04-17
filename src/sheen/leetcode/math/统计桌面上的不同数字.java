package sheen.leetcode.math;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Classname 统计桌面上的不同数字
 * @Date 2024/3/23 00:06
 * @Created by sheen
 * @Description TODO
 */
public class 统计桌面上的不同数字 {
    public static void main(String[] args) {
        统计桌面上的不同数字 s = new 统计桌面上的不同数字();
        System.out.println(s.distinctIntegers(5));
    }
    public int distinctIntegers(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int res = 1;
        queue.offer(n);

        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                int point = queue.poll();
                for(int i = 1; i <= point; i++) {
                    if(point % i == 1 && !set.contains(i)) {
                        res++;
                        queue.offer(i);
                        set.add(i);
                    }
                }
            }
        }

        return res;
    }
}
