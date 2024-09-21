package sheen.leetcode.greedyAlgorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Classname 子序列最大优雅度
 * @Date 2024/6/13 01:38
 * @Created by sheen
 * @Description TODO
 */
public class 子序列最大优雅度 {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (x, y) -> y[0] - x[0]);
        Set<Integer> cat = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        long res = 0;
        long total = 0;
        for(int i = 0; i < items.length; i++) {
            if (i < k) {
                if(cat.contains(items[i][1])) {
                    stack.push(items[i][0]);
                }
                total += items[i][0];
                cat.add(items[i][1]);
            }else if(!stack.isEmpty() && !cat.contains(items[i][1])) {
                cat.add(items[i][1]);
                total -= stack.pop();
                total += items[i][0];
            }
            res = Math.max(res, total + (long)Math.pow(cat.size(), 2));
        }
        return res;
    }
}
