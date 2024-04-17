package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

import java.util.PriorityQueue;

/**
 * @Classname 删除一次得到子数组最大和
 * @Date 2023/6/27 12:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 删除一次得到子数组最大和 {
    public static void main(String[] args) {
        删除一次得到子数组最大和 s = new 删除一次得到子数组最大和();
        System.out.println(s.maximumSum(new int[]{1,-2,0,3}));
    }
    public int maximumSum(int[] arr) {
        boolean flag = false;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            res = Math.max(res, arr[i]);
            if(arr[i] >= 0) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            return res;
        }
        int[] pre = new int[arr.length];
        int[] after = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                pre[i] = arr[i];
                after[arr.length - 1 - i] = arr[arr.length - 1 - i];
            }else {
                pre[i] = arr[i] + pre[i - 1];
                after[arr.length - 1 - i] = after[arr.length - i] + arr[arr.length - 1 - i];
            }
        }
        int[] resPre = new int[arr.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> {
            int xV, yV;
            if(x == -1) {
                xV = 0;
                yV = pre[y];
            }else if(y == -1) {
                yV = 0;
                xV = pre[x];
            }else {
                xV = pre[x];
                yV = pre[y];
            }
            return xV - yV;
        });
        queue.offer(-1);
        for(int i = 0; i < arr.length; i++) {
            if(i > 0) {
                int index = queue.peek();
                if(index == -1) {
                    resPre[i] = pre[i - 1];
                }else {
                    resPre[i] = pre[i - 1] - pre[index];
                }
            }
            queue.offer(i);
        }

        int[] resAfter = new int[arr.length];
        queue = new PriorityQueue<>((x, y) -> {
            int xV, yV;
            if(x == -1) {
                xV = 0;
                yV = after[y];
            }else if(y == -1) {
                yV = 0;
                xV = after[x];
            }else {
                xV = after[x];
                yV = after[y];
            }
            return xV - yV;
        });
        queue.offer(-1);
        for(int i = arr.length - 1; i >= 0; i--) {
            if(i < arr.length - 1) {
                int index = queue.peek();
                if(index == -1) {
                    resAfter[i] = after[i + 1];
                }else {
                    resAfter[i] = after[i + 1] - after[index];
                }
            }
            queue.offer(i);
        }

        for(int i = 0; i < arr.length; i++) {
            res = Math.max(res, Math.max(resPre[i] + resAfter[i] + arr[i], resPre[i] + resAfter[i]));
        }
        return res;
    }
}
