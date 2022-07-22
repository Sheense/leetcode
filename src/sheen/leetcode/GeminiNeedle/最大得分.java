package sheen.leetcode.GeminiNeedle;

public class 最大得分 {

    public static void main(String[] args) {
        最大得分 s = new 最大得分();
        System.out.println(s.maxSum(new int[]{1,4,5,8,9,11,19}, new int[]{2,3,4,11,12}));
    }
    public int maxSum(int[] nums1, int[] nums2) {
        int mod = (int)Math.pow(10,9)+7;
        int i = 0;
        int j = 0;
        int arr1 = 0;
        int arr2 = 0;
        int time1 = 0;
        int time2 = 0;
        while(i<nums1.length||j<nums2.length) {
            if(i==nums1.length) {
                arr2+=nums2[j++];
                if(arr2>=mod) {
                    time2++;
                    arr2%=mod;
                }
                continue;
            }
            if(j==nums2.length) {
                arr1 += nums1[i++];
                if(arr1>=mod) {
                    time1++;
                    arr1%=mod;
                }
                continue;
            }
            if(nums1[i]<nums2[j]) {
                arr1+=nums1[i++];
                if(arr1>=mod) {
                    time1++;
                    arr1%=mod;
                }
            }else if(nums1[i]>nums2[j]){
                arr2+=nums2[j++];
                if(arr2>=mod) {
                    time2++;
                    arr2%=mod;
                }
            }else {
                if(time1>time2) {
                    time2 = time1;
                    arr2 = arr1;
                }else if(time1<time2) {
                    time1 = time2;
                    arr1 = arr2;
                }else if(arr2>arr1){
                    arr1 = arr2;
                }else{
                    arr2 = arr1;
                }
                arr1+=nums1[i++];
                arr2+=nums2[j++];
                if(arr1>=mod) {
                    time1++;
                    arr1%=mod;
                }
                if(arr2>=mod) {
                    time2++;
                    arr2%=mod;
                }
            }
        }
        if(time1>time2) {
            return arr1;
        }else if(time1<time2) {
            return arr2;
        }else {
            if(arr1>arr2) return arr1;
            else return arr2;
        }
    }
}
