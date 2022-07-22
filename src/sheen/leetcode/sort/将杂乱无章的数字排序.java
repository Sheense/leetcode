package sheen.leetcode.sort;

import sheen.leetcode.util.ArrayUtils;

import java.util.PriorityQueue;

/**
 * @Classname 将杂乱无章的数字排序
 * @Date 2022/3/6 12:44 上午
 * @Created by sheen
 * @Description TODO
 */
public class 将杂乱无章的数字排序 {
    public static void main(String[] args) {
        将杂乱无章的数字排序 s = new 将杂乱无章的数字排序();
        ArrayUtils.print(s.sortJumbled(new int[]{8,9,4,0,2,1,3,5,7,6}, new int[]{991,338,38}));
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] tran = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int r = 0;
            if(v == 0) {
                r = mapping[0];
                tran[i] = r;
                continue;
            }
            int j = 1;
            while (v != 0) {
                int yu = v % 10;
                v /= 10;
                r = r + j * mapping[yu];
                j *= 10;
            }
            tran[i] = r;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> {
            if(tran[x] == tran[y]) {
                return x - y;
            }else {
                return tran[x] - tran[y];
            }
        });
        for(int i = 0; i < nums.length; i ++) {
            queue.offer(i);
        }
        int[] res = new int[nums.length];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = nums[queue.poll()];
        }
        return res;
    }
}
