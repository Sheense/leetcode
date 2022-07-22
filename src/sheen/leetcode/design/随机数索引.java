package sheen.leetcode.design;

import java.util.Arrays;
import java.util.Random;

/**
 * @Classname 随机数索引
 * @Date 2022/4/25 12:25 上午
 * @Created by sheen
 * @Description TODO
 */
public class 随机数索引 {
    public static void main(String[] args) {
        Solution s = new Solution(new int[]{2,3,4,1,2,1});

    }
    static class Solution {

        private int[] nums;
        private int[] fu;
        public Solution(int[] nums) {
            this.nums = nums;
            this.fu = new int[nums.length];
            for(int i = 0; i < nums.length; i++) {
                fu[i] = i;
            }
            sort(0, nums.length - 1);
        }

        public int pick(int target) {
            int left = findLeft(target);
            int right = findRight(target);
            int num = right - left + 1;
            Random random = new Random();
            int rank = random.nextInt(num);
            return fu[left + rank];
        }

        private void sort(int left, int right) {
            if(left >= right) {
                return;
            }

            int mid = this.nums[left];
            int f = this.fu[left];
            int a = left;
            int b = right;
            while (a < b) {
                while (a < b && nums[b]>=mid) b--;
                this.nums[a] = this.nums[b];
                this.fu[a] = this.fu[b];
                while (a < b && nums[a] <= mid) a++;
                this.nums[b] = this.nums[a];
                this.fu[b] = this.fu[a];
            }

            this.nums[a] = mid;
            this.fu[a] = f;

            sort(left, a - 1);
            sort(a + 1, right);
        }

        private int findLeft(int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] >= target) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private int findRight(int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] > target) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            return right;
        }
    }

}
