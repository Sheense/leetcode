package sheen.leetcode.GeminiNeedle;

/**
 * @Classname 神奇字符串
 * @Date 2022/10/31 1:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 神奇字符串 {
    public int magicalString(int n) {
        if(n <= 3) {
            return 1;
        }

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 2;
        int i = 3;
        int j = 4;
        int now = 1;
        while (j < arr.length) {
            arr[j++] = now;
            if(j < arr.length && arr[i] == 2) {
                arr[j++] = now;
            }
            i++;
            if(now == 1) {
                now = 2;
            }else {
                now = 1;
            }
        }

        int res = 0;
        for(i = 1; i < arr.length; i++) {
            if(arr[i] == 1) {
                res ++;
            }
        }
        return res;
    }
}
