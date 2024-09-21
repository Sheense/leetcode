package sheen.leetcode.bitOperation;

/**
 * @Classname 数组最后一个元素的最小值
 * @Date 2024/8/22 01:07
 * @Created by sheen
 * @Description TODO
 */
public class 数组最后一个元素的最小值 {
    public static void main(String[] args) {
        数组最后一个元素的最小值 s = new 数组最后一个元素的最小值();
        System.out.println(s.minEnd(3, 4));
    }
    public long minEnd(int n, int x) {
        n = n - 1;

        int[] arr1 = new int[128];
        int[] arr2 = new int[128];
        int i = 0;
        while (n != 0) {
            arr1[i++] = n & 1;
            n >>= 1;
        }

        i = 0;
        while(x != 0) {
            arr2[i++] = x & 1;
            x >>= 1;
        }

        i = 0;
        int j = 0;
        int[] res = new int[128];
        int z = 0;
        while (i < arr1.length && j < arr2.length) {
            if(arr2[j] == 1) {
                res[z] = 1;
            }else {
                res[z] = arr1[i++];
            }
            z++;
            j++;
        }

        long ans = 0;
        boolean flag = false;
        for(int q = res.length - 1; q >= 0; q--){
            if(res[q] == 1) {
                flag = true;
            }

            if(flag) {
                ans <<= 1;
                ans |= res[q];
            }
        }

        return ans;


    }
}
