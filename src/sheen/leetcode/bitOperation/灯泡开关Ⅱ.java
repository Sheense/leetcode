package sheen.leetcode.bitOperation;

import java.util.*;

/**
 * @Classname 灯泡开关Ⅱ
 * @Date 2022/9/15 12:29 上午
 * @Created by sheen
 * @Description TODO
 */
public class 灯泡开关Ⅱ {
    public static void main(String[] args) {
        灯泡开关Ⅱ s = new 灯泡开关Ⅱ();
        System.out.println(s.flipLights(3, 2));
    }
    public int flipLights(int n, int presses) {
        char[] light = new char[n];
        Arrays.fill(light, '1');
        Queue<char[]> queue = new LinkedList<>();
        queue.offer(light);
        while (presses-- != 0) {
            Set<String> set = new HashSet<>();
            int size = queue.size();
            while (size-- != 0) {
                char[] cs = queue.poll();
                char[] c0 = new char[n];
                for(int i = 0; i < cs.length; i++) {
                    if(cs[i] == '0') {
                        c0[i] = '1';
                    }else {
                        c0[i] = '0';
                    }
                }
                String str = String.valueOf(c0);
                if(!set.contains(str)) {
                    set.add(str);
                    queue.offer(c0);
                }

                char[] c1 = Arrays.copyOf(cs, cs.length);
                for(int i = 0; i < cs.length; i+=2) {
                    if(cs[i] == '0') {
                        c1[i] = '1';
                    }else {
                        c1[i] = '0';
                    }
                }
                str = String.valueOf(c1);
                if(!set.contains(str)) {
                    set.add(str);
                    queue.offer(c1);
                }

                char[] c2 = Arrays.copyOf(cs, cs.length);
                for(int i = 1; i < cs.length; i+=2) {
                    if(cs[i] == '0') {
                        c2[i] = '1';
                    }else {
                        c2[i] = '0';
                    }
                }
                str = String.valueOf(c2);
                if(!set.contains(str)) {
                    set.add(str);
                    queue.offer(c2);
                }

                char[] c3 = Arrays.copyOf(cs, cs.length);
                int k = 0;
                while (3 * k + 1 <= cs.length) {
                    if(cs[3 * k] == '0') {
                        c3[3 * k] = '1';
                    }else {
                        c3[3 * k] = '0';
                    }
                    k++;
                }

                str = String.valueOf(c3);
                if(!set.contains(str)) {
                    set.add(str);
                    queue.offer(c3);
                }
            }
        }

        return queue.size();

    }

}
