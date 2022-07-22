package sheen.leetcode.array;

/**
 * @Classname 统计数组中峰和谷的数量
 * @Date 2022/3/20 4:33 下午
 * @Created by sheen
 * @Description TODO
 */
public class 统计数组中峰和谷的数量 {
    public static void main(String[] args) {
        统计数组中峰和谷的数量 s = new 统计数组中峰和谷的数量();
        System.out.println(s.countHillValley(new int[]{2,4,1,1,6,5}));
    }
    public int countHillValley(int[] nums) {
        int index = 1;
        int res = 0;
        while (index < nums.length - 1) {
            int i = index + 1;
            if(nums[index - 1] > nums[index]) {
                while (i < nums.length && nums[i] == nums[index]) {
                    i++;
                }
                if(i == nums.length) {
                    break;
                }
                if(nums[i] > nums[index]) {
                    res++;
                }
            }else if(nums[index - 1] < nums[index]) {
                while (i < nums.length && nums[i] == nums[index]) {
                    i++;
                }
                if(i == nums.length) {
                    break;
                }
                if(nums[i] < nums[index]) {
                    res++;
                }
            }
            index = i;
        }
        return res;
    }
}
