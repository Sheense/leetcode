package sheen.leetcode.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 设计有序流
 * @Date 2022/8/16 12:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 设计有序流 {
    static class OrderedStream {

        private int ptr = 1;
        private String[] list;
        public OrderedStream(int n) {
            list = new String[n];
        }

        public List<String> insert(int idKey, String value) {
            list[idKey - 1] = value;
            List<String> res = new ArrayList<>();
            if(idKey == ptr) {
                while (ptr - 1 < list.length && list[ptr - 1] != null) {
                    res.add(list[ptr - 1]);
                    ptr ++;
                }
            }
            return res;
        }
    }
}
