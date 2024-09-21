package sheen.leetcode.math;

/**
 * @Classname 美丽下标对的数目
 * @Date 2024/6/20 00:35
 * @Created by sheen
 * @Description TODO
 */
public class 美丽下标对的数目 {
    public int countBeautifulPairs(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length - 1; i ++) {
            for(int j = i + 1; j < nums.length; j++) {
                String str1 = String.valueOf(nums[i]);
                String str2 = String.valueOf(nums[j]);
                int a = str1.charAt(0) - '0';
                int b = str2.charAt(str2.length() - 1) - '0';
                if(gcd(Math.max(a,b), Math.min(a,b)) == 1) {
                    res ++;
                }
            }
        }
        return res;
    }

    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
