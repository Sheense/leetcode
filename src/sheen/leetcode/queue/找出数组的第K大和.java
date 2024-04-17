package sheen.leetcode.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Classname 找出数组的第K大和
 * @Date 2024/3/9 13:53
 * @Created by sheen
 * @Description TODO
 */
public class 找出数组的第K大和 {
    public static void main(String[] args) {
        找出数组的第K大和 s = new 找出数组的第K大和();
        System.out.println(s.kSum(new int[]{-530219056,353285209,493533664}, 6));
    }
    public long kSum(int[] nums, int k) {
        long total = 0;
        for(int i = 0; i < nums.length; i++ ) {
            if (nums[i] >= 0) {
                total += nums[i];
            }else {
                nums[i] = -nums[i];
            }
        }

        long ret = 0;
        Arrays.sort(nums);
        PriorityQueue<long[]> queue = new PriorityQueue<>((x, y) -> {
            if(x[0] - y[0] >= 0) return 1;
            else return -1;
        });
        queue.offer(new long[]{(long)nums[0], 0L});
        for(int i = 2; i <= k; i++) {
            long[] point = queue.poll();
            int index = (int)point[1];
            ret = point[0];
            if(index == nums.length - 1) {
                continue;
            }
            queue.offer(new long[]{point[0] + nums[index + 1], index + 1});
            queue.offer(new long[]{point[0] + nums[index + 1] - nums[index], index + 1});
        }

        return total - ret;
    }
}
