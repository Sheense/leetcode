package sheen.leetcode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 循环码排列
 * @Date 2023/2/23 12:48 上午
 * @Created by sheen
 * @Description TODO
 */
public class 循环码排列 {
    public static void main(String[] args) {
        循环码排列 s = new 循环码排列();
        System.out.println(s.circularPermutation(2, 3));
    }
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        list.add(start);
        for(int i = 0; i < n; i++) {
            int m = list.size();
            for(int j = m - 1; j >= 0; j--) {
                list.add(((list.get(j) ^ start) | (1 << i)) ^ start);
            }
        }
        return list;
    }


}
