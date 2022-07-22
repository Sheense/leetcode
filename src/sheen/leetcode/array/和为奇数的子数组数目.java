package sheen.leetcode.array;

public class 和为奇数的子数组数目 {
    public int numOfSubarrays(int[] arr) {
        int jishu_num = 0;
        int oushu_num = 0;
        for(int i=1;i<arr.length;i++) {
            arr[i] += arr[i-1];
        }
        int res = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]%2==1) {
                res+=oushu_num;
                jishu_num++;
                res++;
            }else {
                res+=jishu_num;
                oushu_num++;
            }
            res%=1000000007;
        }
        return res;
    }
}
