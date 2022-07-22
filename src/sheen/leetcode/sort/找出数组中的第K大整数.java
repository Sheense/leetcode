package sheen.leetcode.sort;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname 找出数组中的第K大整数
 * @Date 2021/8/29 10:38 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找出数组中的第K大整数 {
    public String kthLargestNumber(String[] nums, int k) {
        return Stream.of(nums).sorted((o1, o2) -> compare(o2, o1)).collect(Collectors.toList()).get(k-1);
    }

    public int compare(String a, String b) {
        if(a.length() > b.length()) {
            return 1;
        } else if(a.length() < b.length()) {
            return -1;
        } else {
            for(int i = 0; i < b.length(); i++) {
                if(a.charAt(i) > b.charAt(i)) return 1;
                else if(a.charAt(i) < b.charAt(i)) return -1;
            }
        }
        return 0;
    }
}
