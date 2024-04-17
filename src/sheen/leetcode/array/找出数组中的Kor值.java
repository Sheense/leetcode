package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 找出数组中的Kor值
 * @Date 2024/3/6 00:21
 * @Created by sheen
 * @Description TODO
 */
public class 找出数组中的Kor值 {
    public int findKOr(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= 31; i++) {
            int count = 0;
            for(int num : nums) {
                int mod = 1 << i;
                if((mod & num) != 0) {
                    count++;
                }
            }

            if(count >= k) {
                list.add(i);
            }
        }

        int res = 0;
        for(int item : list) {
            res |= (1 << item);
        }
        return res;
    }
}
