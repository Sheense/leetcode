package sheen.leetcode.hash;

public class 缺失的第一个正数 {

    public static void main(String[] args) {
        缺失的第一个正数 s = new 缺失的第一个正数();
        System.out.println(s.firstMissingPositive(new int[]{3,4,-1,1}));
    }

    public int firstMissingPositive(int[] nums) {
        boolean hasOne = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=nums.length;i++) {
            sb.append("0");
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>nums.length+1||nums[i]<=0) {
                nums[i]=1;
            }else {
                if(nums[i]==1) hasOne = true;
                sb.setCharAt(nums[i]-1, '1');
            }
        }
        if(!hasOne) return 1;
        String str = sb.toString();
        for(int i=0;i<sb.length();i++) {
            if(str.charAt(i)=='0') return i+1;
        }
        return 0;
    }
}
