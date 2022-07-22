package sheen.leetcode.array;

public class 删除一个元素使数组严格递增 {
    public boolean canBeIncreasing(int[] nums) {
        if(nums.length == 2) return true;
        for(int i = 0; i < nums.length; i++) {
            int pre = i == 0 ? 1 : 0;
            int index = pre;
            boolean flag = true;
            while (index < nums.length) {
                index ++;
                if(index == i || index == nums.length) {
                    continue;
                }
                if(nums[index] < nums[pre]) {
                    flag = false;
                    break;
                }
                pre = index;
            }
            if(flag) return true;
        }
        return false;
    }
}
