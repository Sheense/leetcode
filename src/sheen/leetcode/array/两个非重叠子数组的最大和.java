package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 两个非重叠子数组的最大和
 * @Date 2023/4/26 12:02 上午
 * @Created by sheen
 * @Description TODO
 */
public class 两个非重叠子数组的最大和 {
    public static void main(String[] args) {
        两个非重叠子数组的最大和 s = new 两个非重叠子数组的最大和();
        System.out.println(s.maxSumTwoNoOverlap(new int[]{0,6,5,2,2,5,1,9,4}, 1, 2));
    }
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] pre = new int[nums.length];
        Arrays.fill(pre, -1);
        int[] after = new int[nums.length];
        Arrays.fill(after, -1);
        int i = 0;
        int v = 0;
        while (i < nums.length) {
            if(i < firstLen) {
                while (i < firstLen) {
                    v += nums[i++];
                }
                pre[i - 1] = v;
            }

            v += nums[i];
            v -= nums[i - firstLen];
            pre[i] = Math.max(pre[i - 1], v);
            i++;
        }
        i = after.length - 1;
        v = 0;
        while (i >= 0) {
            if(i >= nums.length - firstLen) {
                while (i >= nums.length - firstLen) {
                    v += nums[i--];
                }
                after[i + 1] = v;
            }

            v += nums[i];
            v -= nums[i + firstLen];
            after[i] = Math.max(after[i + 1], v);
            i--;
        }

        int[] arr = new int[nums.length];
        for(int j = 0; j < nums.length; j++) {
            if(j == 0) {
                arr[j] = nums[j];
            }else {
                arr[j] = arr[j - 1] + nums[j];
            }
        }

        int res = 0;
        i = 0;
        while (i < arr.length) {
            if(i < secondLen - 1) {
                i++;
            }else {
                int second = i == secondLen - 1 ? arr[secondLen - 1] : (arr[i] - arr[i - (secondLen - 1) - 1]);
                if(i - (secondLen - 1) - 1 >= 0) {
                    res = Math.max(res, second + pre[i - (secondLen - 1) - 1]);
                }

                if(i + 1 < arr.length) {
                    res = Math.max(res, second + after[i + 1]);
                }
                i++;
            }
        }
        return res;
    }
}
