package sheen.leetcode.greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 和为K的最少斐波那契数字数目
 * @Date 2022/2/3 6:09 下午
 * @Created by sheen
 * @Description TODO
 */
public class 和为K的最少斐波那契数字数目 {
    public static void main(String[] args) {
        和为K的最少斐波那契数字数目 s = new 和为K的最少斐波那契数字数目();
        System.out.println(s.findMinFibonacciNumbers(1000000000));
    }
    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        int i = list.size() - 1;
        while (list.get(i) + list.get(i - 1) <= k) {
            list.add(list.get(i) + list.get(i - 1));
            i++;
        }
        int res = 0;
        while (k > 0) {
            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if(k >= list.get(mid)) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            k -= list.get(right);
            res++;
        }
        return res;
    }
}
