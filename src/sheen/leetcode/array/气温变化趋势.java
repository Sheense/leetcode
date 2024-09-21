package sheen.leetcode.array;

/**
 * @Classname 气温变化趋势
 * @Date 2024/6/21 01:20
 * @Created by sheen
 * @Description TODO
 */
public class 气温变化趋势 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int[] a = new int[temperatureA.length - 1];
        int[] b = new int[temperatureB.length - 1];
        for(int i = 0; i < temperatureA.length - 1; i++) {
            a[i] = Integer.compare(temperatureA[i + 1], temperatureA[i]);
            b[i] = Integer.compare(temperatureB[i + 1], temperatureB[i]);
        }

        int left = 0;
        int right = 0;
        int res = 0;
        while (left < a.length) {
            while (right < a.length && a[right] == b[right] ) {
                right++;
            }
            res = Math.max(res, right - left);
            right++;
            left = right;
        }
        return res;
    }
}
