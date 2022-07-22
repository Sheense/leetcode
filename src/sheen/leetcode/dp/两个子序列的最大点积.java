package sheen.leetcode.dp;


public class 两个子序列的最大点积 {

    public static void main(String[] args) {
        两个子序列的最大点积 s = new 两个子序列的最大点积();
        System.out.println(s.maxDotProduct(new int[]{3,-2},new int[]{2,-6,7}));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        boolean flag1 = true;
        boolean fu1 = nums1[0]>=0? true:false;
        int max_1 = Integer.MIN_VALUE;
        int min_1 = Integer.MAX_VALUE;
        int max_2 = Integer.MIN_VALUE;
        int min_2 = Integer.MAX_VALUE;
        for(int i=1;i<nums1.length;i++) {
            boolean item = nums1[i]>=0? true:false;
            if(nums1[i]>max_1) {
                max_1 =nums1[i];
            }
            if(nums1[i]<min_1) {
                min_1 = nums1[i];
            }
            if(item!=fu1) {
                flag1 = false;
                break;
            }
        }

        boolean flag2 = true;
        boolean fu2 = nums2[0]>=0? true:false;
        for(int i=1;i<nums2.length;i++) {
            boolean item = nums2[i]>=0? true:false;
            if(nums2[i]>max_2) {
                max_2 =nums2[i];
            }
            if(nums2[i]<min_2) {
                min_2 = nums2[i];
            }
            if(item!=fu2) {
                flag2 = false;
                break;
            }
        }
        if(flag1&&flag2&&(fu1!=fu2)) {
            return max_1*min_2>max_2*min_1?max_1*min_2:max_2*min_1;
        }
        int[][] dp = new int[nums1.length][nums2.length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums1.length;i++) {
            for(int j=0;j<nums2.length;j++) {
                if(i==0&&j==0) {
                    int num = nums1[i]*nums2[j];
                    if(num>0) {
                        dp[i][j] = num;
                    }
                }else if(j==0) {
                    int num = nums1[i]*nums2[j];
                    dp[i][j] = num>dp[i-1][j]?num:dp[i-1][j];
                }else if(i==0){
                    int num = nums1[i]*nums2[j];
                    dp[i][j] = num>dp[i][j-1]?num:dp[i][j-1];
                } else{
                    int num = nums1[i]*nums2[j] ;
                    if(num <0) {
                        int m = Math.max(Math.max(dp[i][j-1],dp[i-1][j-1]), dp[i-1][j]);
                        dp[i][j] =m;
                    }else {
                        int m = Math.max(Math.max(dp[i][j-1],dp[i-1][j-1]+num), dp[i-1][j]);
                        dp[i][j] = m;
                    }
                }
                if(dp[i][j]>max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}
