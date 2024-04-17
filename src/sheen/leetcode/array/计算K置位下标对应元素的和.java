package sheen.leetcode.array;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname 计算K置位下标对应元素的和
 * @Date 2024/1/25 00:02
 * @Created by sheen
 * @Description TODO
 */
public class 计算K置位下标对应元素的和 {
    public static void main(String[] args) {
        计算K置位下标对应元素的和 s = new 计算K置位下标对应元素的和();
        System.out.println(s.sumIndicesWithKSetBits(Arrays.asList(5,10,1,5,2), 1));
    }
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;

        for(int i = 0; i < nums.size(); i++) {
            int v = i;
            int count = 0;
            while (v != 0) {
                if((v & 1) == 1) {
                    count++;
                }
                v>>=1;
            }
            if(count == k) {
                res += nums.get(i);
            }
        }

        return res;
    }
}
