package sheen.leetcode.greedyAlgorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Classname 老鼠和奶酪
 * @Date 2023/6/7 12:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 老鼠和奶酪 {
    public static void main(String[] args) {
        老鼠和奶酪 s = new 老鼠和奶酪();
        System.out.println(s.miceAndCheese(new int[]{3, 3}, new int[]{3, 5}, 1));
    }
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int sum = 0;
        for(int i = 0; i < reward2.length; i++) sum += reward2[i];
        int[] diff = new int[reward1.length];
        for(int i = 0; i < reward2.length; i++) {
            diff[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diff);
        for(int i = diff.length - 1; i >= (diff.length - k); i--) {
            sum += diff[i];
        }

        return sum;
    }
}
