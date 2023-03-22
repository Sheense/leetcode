package sheen.leetcode.bitOperation;

/**
 * @Classname 按位与为零的三元组
 * @Date 2023/3/4 1:31 上午
 * @Created by sheen
 * @Description TODO
 */
public class 按位与为零的三元组 {
    public static void main(String[] args) {
        按位与为零的三元组 s = new 按位与为零的三元组();
        System.out.println(s.countTriplets(new int[]{2, 1, 3}));
    }
    public int countTriplets(int[] nums) {
        int[] arr = new int[1 << 16];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                arr[nums[i] & nums[j]]++;
            }
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if((nums[i] & j) == 0) {
                    res += arr[j];
                }
            }
        }

        return res;
    }
}
