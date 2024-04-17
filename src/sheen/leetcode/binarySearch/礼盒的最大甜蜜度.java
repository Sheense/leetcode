package sheen.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @Classname 礼盒的最大甜蜜度
 * @Date 2023/6/1 12:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class 礼盒的最大甜蜜度 {
    public static void main(String[] args) {
        礼盒的最大甜蜜度 s = new 礼盒的最大甜蜜度();
        System.out.println(s.maximumTastiness(new int[]{13,5,1,8,21,2}, 3));
    }
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int right = price[price.length - 1] - price[0];
        int left = Integer.MAX_VALUE;
        for(int i = 0; i < price.length - 1; i++) {
            left = Math.min(left, price[i + 1] - price[i]);
        }
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(find(price, mid, k)) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }

    public boolean find(int[] price, int mid, int k) {
        int count = 0;
        int pre = Integer.MIN_VALUE / 2;
        for(int prev : price) {
            if(prev - pre >= mid) {
                pre = prev;
                count++;
            }
        }
        return count >= k;
    }
}
