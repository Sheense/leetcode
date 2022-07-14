package com.company.queue;

import com.company.util.ArrayUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 行星碰撞
 * @Date 2022/7/13 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 行星碰撞 {
    public static void main(String[] args) {
        行星碰撞 s = new 行星碰撞();
        ArrayUtils.print(s.asteroidCollision(new int[]{10, 2, -5}));
    }
    public int[] asteroidCollision(int[] asteroids) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < asteroids.length; i++) {
            queue.offer(asteroids[i]);
        }

        while (true && !queue.isEmpty()) {
            boolean flag = true;
            Queue<Integer> tmp = new LinkedList<>();
            Integer a = queue.poll();
            do {
                if(queue.isEmpty()) {
                    break;
                }
                int b = queue.poll();
                if(a > 0 && b < 0) {
                    flag = false;
                    if(Math.abs(a) == Math.abs(b)) {
                        if(queue.isEmpty()) {
                            a = null;
                            break;
                        }
                        a = queue.poll();
                    }else if(Math.abs(a) < Math.abs(b)) {
                        a = b;
                    }
                }else {
                    tmp.offer(a);
                    a = b;
                }
            }while (!queue.isEmpty());

            if(a != null) {
                tmp.offer(a);
            }
            queue = tmp;
            if(flag) {
                break;
            }
        }
        if(queue.isEmpty()) {
            return new int[]{};
        }
        int[] res = new int[queue.size()];
        for(int i = 0 ; i < res.length; i++) {
            res[i] = queue.poll();
        }

        return res;
    }
}
