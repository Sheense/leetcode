package sheen.leetcode.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 重新排序得到2的幂
 * @Date 2021/10/28 1:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 重新排序得到2的幂 {
    public boolean reorderedPowerOf2(int n) {
        List<int[]> list = new ArrayList<>();
        int index = 0;
        int max = 1000000000;
        while (Math.pow(2, index) <= max) {
            int[] arr = new int[10];
            int value = (int)Math.pow(2, index);
            while (value > 0) {
                arr[value % 10] ++;
                value /= 10;
            }
            list.add(arr);
            index++;
        }
        int [] target = new int[10];
        while (n > 0) {
            target[n % 10]++;
            n /= 10;
        }

        for(int[] arr : list) {
            boolean flag = true;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] != target[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return true;
            }
        }
        return false;
    }
}
