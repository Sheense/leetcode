package sheen.leetcode.binarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname 最大合金数
 * @Date 2024/1/27 11:29
 * @Created by sheen
 * @Description TODO
 */
public class 最大合金数 {
    public static void main(String[] args) {
        最大合金数  s= new 最大合金数();
        System.out.println(s.maxNumberOfAlloys(4, 4, 17, Arrays.asList(Arrays.asList(10,10,1,5), Arrays.asList(9,7,7,1),
                Arrays.asList(6,3,5,9), Arrays.asList(2,10,2,7)),
                Arrays.asList(9,8,2,7), Arrays.asList(9,2,6,10)
));
    }
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(isCan(budget, composition, stock, cost, mid)) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }

    public boolean isCan(int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost, int target) {
        for(int i = 0; i < composition.size(); i++) {
            List<Integer> item = composition.get(i);
            int copyBudget = budget;
            boolean flag = true;
            for(int j = 0; j < item.size(); j++) {
                long yu = (long)target * item.get(j) - stock.get(j);
                if(yu > 0) {
                    long allCost = yu * cost.get(j);
                    if(allCost > copyBudget) {
                        flag = false;
                        break;
                    }
                    copyBudget -= allCost;
                }
            }
            if(flag) {
                return true;
            }
        }
        return false;
    }
}
