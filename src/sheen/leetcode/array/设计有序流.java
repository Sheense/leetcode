package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class 设计有序流 {

    public static void main(String[] args) {
        OrderedStream s = new OrderedStream(5);
        s.insert(3,"cccc");
        s.insert(1, "aaaa");
        s.insert(2, "bbbb");
        s.insert(5, "eeee");
        s.insert(4, "dddd");
    }
    static class OrderedStream {

        private String[] arr = null;
        private int ptr = 1;
        public OrderedStream(int n) {
            arr = new String[n];
        }

        public List<String> insert(int id, String value) {
            arr[id-1] = value;
            List<String> res = new ArrayList<>();
            if(id==ptr) {
                int index = id;
                for(int i=ptr-1;i<arr.length;i++) {
                    if(arr[i]!=null) {
                        res.add(arr[i]);
                        index++;
                    }else {
                        ptr = index;
                        break;
                    }
                }
            }
            return res;
        }
    }
}
