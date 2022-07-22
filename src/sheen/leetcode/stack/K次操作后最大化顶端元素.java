package sheen.leetcode.stack;

/**
 * @Classname K次操作后最大化顶端元素
 * @Date 2022/3/13 4:59 下午
 * @Created by sheen
 * @Description TODO
 */
public class K次操作后最大化顶端元素 {
    public static void main(String[] args) {
        K次操作后最大化顶端元素 s = new K次操作后最大化顶端元素();
        System.out.println(s.maximumTop(new int[]{35,43,23,86,23,45,84,2,18,83,79,28,54,81,12,94,14,0,0,29,94,12,13,1,48,85,22,95,24,5,73,10,96,97,72,41,52,1,91,3,20,22,41,98,70,20,52,48,91,84,16,30,27,35,69,33,67,18,4,53,86,78,26,83,13,96,29,15,34,80,16,49
        }, 15));
    }
    public int maximumTop(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            System.out.println("i=" + i +", v=" + nums[i]);
        }
        if(nums.length == 1 && k % 2 == 1) {
            return -1;
        }

        int res = -1;
        for(int i = 0; i < k - 1 && i < nums.length; i++) {
            res = Math.max(res, nums[i]);
        }

        if(k < nums.length) {
            res = Math.max(res, nums[k]);
        }

        return res;
    }

}
