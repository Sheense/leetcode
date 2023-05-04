package sheen.algorithm.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname baidu
 * @Date 2023/3/22 7:35 下午
 * @Created by sheen
 * @Description TODO
 */
public class baidu {
    public static void main(String[] args) {
        int[] a = new int[2];
        getMax(a);

        System.out.println(getMax(new int[]{3,-1,2, -2,1,-1, 2}));
        System.out.println(getMax(new int[]{-3,4,-2,5,1,-2}));
    }

    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int now = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if(arr[i] + now < 0) {
                now = 0;
            }else {
                now += arr[i];
                max = Math.max(now, max);
            }
        }
        return max;
    }
}
