package sheen.leetcode.array;

public class 寻找数组的中心索引 {
    public static void main(String[] args) {
        寻找数组的中心索引 s = new 寻找数组的中心索引();
        System.out.println(s.pivotIndex(new int[]{1,7,3,6,5,6}));
    }
    public int pivotIndex(int[] nums) {
        int begin[] = new int[nums.length];
        int last[] = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(i!=0) {
                begin[i] = begin[i-1] + nums[i-1];
                last[nums.length-i-1]=last[nums.length-i]+nums[nums.length-i];
            }
        }
        for(int i=0;i<nums.length;i++) {
            if(begin[i]==last[i]){
                return i;
            }
        }
        return -1;
    }
}
