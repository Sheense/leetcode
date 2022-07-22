package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;

//摩尔投票法  精髓：抵消
public class 求众数II {

    public static void main(String[] args) {
        求众数II s = new 求众数II();
        System.out.println(s.majorityElement(new int[]{1,1,1,3,3,2,2,2}));
    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length==0) return res;
        int a = nums[0];
        int aNum = 0;
        int b = nums[0];
        int bNum = 0;
        for(int i=0;i<nums.length;i++) {
            if(a==nums[i]||(aNum==0&&b!=nums[i])) {
                a = nums[i];
                aNum++;
            } else if(bNum==0||b==nums[i]) {
                b = nums[i];
                bNum++;
            }else if(bNum!=0&&aNum!=0&&a!=nums[i]&&b!=nums[i]) {
                aNum--;
                bNum--;
            }
        }
        int countA = 0;
        int countB = 0;
        //aNum!=0、bNum!=0 可能无解
        for(int i=0;i<nums.length;i++) {
            if(bNum!=0&&nums[i]==b) countB++;
            if(aNum!=0&&nums[i]==a) countA++;
        }
        if(aNum!=0&&countA*3>nums.length) {
            res.add(a);
        }
        if(bNum!=0&&countB*3>nums.length) {
            res.add(b);
        }
        return res;
    }
}
