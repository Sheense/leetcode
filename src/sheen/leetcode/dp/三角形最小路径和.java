package sheen.leetcode.dp;

import java.util.Arrays;
import java.util.List;

public class 三角形最小路径和 {

    public static void main(String[] args) {
        三角形最小路径和 d = new 三角形最小路径和();
        System.out.println(d.minimumTotal(
                            Arrays.asList(Arrays.asList(2),
                                      Arrays.asList(3,4),
                                      Arrays.asList(6,5,7),
                                      Arrays.asList(4,1,8,3))
        ));
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--) {
            for(int j = 0;j<triangle.get(i).size();j++) {
                triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
