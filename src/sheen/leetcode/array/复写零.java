package sheen.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 复写零
 * @Date 2022/6/17 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 复写零 {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        int i = 0;
        while (i < arr.length) {
            int v = queue.poll();
            arr[i++] = v;
            if(v == 0 && i < arr.length) {
                arr[i++] = v;
            }
        }
    }
}
