package sheen.leetcode.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 最近的请求次数
 * @Date 2022/5/6 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最近的请求次数 {
    static class RecentCounter {

        private List<Integer> list = new ArrayList<>();
        private int left = 0;
        public RecentCounter() {

        }

        public int ping(int t) {
            if(list.size() == 0) {
                list.add(t);
                return 1;
            }
            while (left < list.size() && t - list.get(left) > 3000) {
                left++;
            }
            list.add(t);
            return list.size() - left;
        }
    }
}
