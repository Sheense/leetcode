package sheen.leetcode.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname 小美的跑腿代购
 * @Date 2021/8/30 12:58 上午
 * @Created by sheen
 * @Description TODO
 */
public class 小美的跑腿代购 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int n = Integer.valueOf(str[0]);
        int m = Integer.valueOf(str[1]);
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++) {
            str = scanner.nextLine().split(" ");
            arr[i][0] = Integer.valueOf(str[0]);
            arr[i][1] = Integer.valueOf(str[1]);
            arr[i][2] = i + 1;
        }

        Arrays.sort(arr, (o1, o2) -> {
            int value1 = o1[0] + o1[1] * 2;
            int value2 = o2[0] + o2[1] * 2;
            if(value1 == value2) {
                return o1[2] - o2[2];
            }else {
                return value2 > value1 ? 1 : -1;
            }
        });
        int[] res = new int[m];
        for(int i = 0; i < m; i++) {
            res[i] = arr[i][2];
        }
        Arrays.sort(res);
        String ans = "";
        for(int i = 0; i < m; i++) {
            ans += arr[i][2] + " ";
        }
        System.out.println(ans);
    }
}
