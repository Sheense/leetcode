package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

public class 消失的两个数字 {

    public static void main(String[] args) {
        消失的两个数字 s = new 消失的两个数字();
        ArrayUtils.print(s.missingTwo(new int[]{2,3}));
    }

    public int[] missingTwo(int[] nums) {
        int [] res = new int[2];
        int a = 0;
        int b = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=i+1) {
                while(nums[i]!=i+1&&nums[i]!=0) {
                    int item = nums[i];
                    if(item==nums.length+1){
                        a = item;
                        nums[i]= 0;
                        break;
                    }
                    if(item==nums.length+2) {
                        b = item;
                        nums[i]=0;
                        break;
                    }
                    int value = nums[item-1];
                    nums[item-1] = item;
                    nums[i] = value;
                }
            }
        }
        int index = 0;
        for(int i=0;i<nums.length+2;i++) {
            if(index==2) break;
            if(i==nums.length) {
                if(a==0) res[index++] = nums.length+1;
                continue;
            }
            if(i==nums.length+1) {
                if(b==0) res[index++] = nums.length+2;
                continue;
            }
            if(nums[i]==0) res[index++] = i+1;
        }
        return res;
    }
}
