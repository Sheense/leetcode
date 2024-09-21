package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 区分黑球与白球
 * @Date 2024/6/6 00:18
 * @Created by sheen
 * @Description TODO
 */
public class 区分黑球与白球 {
    public static void main(String[] args) {
        区分黑球与白球 s = new 区分黑球与白球();
        System.out.println(s.minimumSteps("100"));
    }
    public long minimumSteps(String s) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                list.add(i);
            }
        }
        long res = 0;
        int j = 0;
        for(int i = s.length() - 1; i >= 0 && j < list.size(); i--) {
            if( s.charAt(i) == '0') {
                if (list.get(j) >= i) {
                    break;
                }
                res += i - list.get(j++);
            }
        }

        return res;
    }
}
