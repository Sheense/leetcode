package sheen.leetcode.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 找出给定方程的正整数解
 * @Date 2023/2/18 5:25 下午
 * @Created by sheen
 * @Description TODO
 */
public class 找出给定方程的正整数解 {
    static class CustomFunction {

        public int f(int x, int y){
            return 0;
        }
    };
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i <= 1000; i++) {
            for(int j = 1; j <= 1000; j++) {
                if(customfunction.f(i, j) >= z) {
                    if(customfunction.f(i, j) == z) {
                        res.add(Arrays.asList(i, j));
                    }
                    break;
                }
            }
        }
        return res;
    }
}
