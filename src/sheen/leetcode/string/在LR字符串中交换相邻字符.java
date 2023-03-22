package sheen.leetcode.string;

/**
 * @Classname 在LR字符串中交换相邻字符
 * @Date 2022/10/2 1:10 下午
 * @Created by sheen
 * @Description TODO
 */
public class 在LR字符串中交换相邻字符 {
    public static void main(String[] args) {
        在LR字符串中交换相邻字符 s = new 在LR字符串中交换相邻字符();
        System.out.println(s.canTransform("RXR", "XXR"));
    }
    public boolean canTransform(String start, String end) {
        int i = 0;
        int j = 0;
        while (i < start.length() || j < end.length()) {
            while (i < start.length() && start.charAt(i) == 'X') {
                i++;
            }
            while (j < end.length()  && end.charAt(j) == 'X') {
                j++;
            }
            if(i < start.length() && j < end.length()) {
                if(start.charAt(i) == end.charAt(j)) {
                    if(start.charAt(i) == 'L') {
                        if(j > i) {
                            return false;
                        }
                    }else {
                        if(j < i) {
                            return false;
                        }
                    }
                    i++;
                    j++;
                }else {
                    return false;
                }
            }else if((i >= start.length() && j < end.length()) || (i < start.length() && j >= end.length())) {
                return false;
            }
        }
        return true;
    }


}
