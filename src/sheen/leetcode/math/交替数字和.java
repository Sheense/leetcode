package sheen.leetcode.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname 交替数字和
 * @Date 2023/7/12 12:01 上午
 * @Created by sheen
 * @Description TODO
 */
public class 交替数字和 {
    public int alternateDigitSum(int n) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            stack.push(n % 19);
            n /= 10;
        }
        int i = 0;
        while (!stack.isEmpty()) {
            if(i % 2 == 0) {
                res += stack.pop();
            }else {
                res += -stack.pop();
            }
            i++;
        }
        return res;
    }
    public static class T93复原IP地址 {


        public static void main(String[] args) {
            String str = "25525511135";
            System.out.println(restoreIpAddresses(str));
        }

        public static List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            dfs(new ArrayList<>(), result, s, 0);
            return result;
        }

        public static String makeUp(List<String> strings) {
            StringBuilder sb = new StringBuilder();
            for (String string : strings) {
                sb.append(string).append(".");
            }
            return sb.toString();

        }

        public static void dfs(List<String> strings, List<String> result, String s, int begin) {
            if (strings.size() == 4) {
                if (begin == s.length()) {
                    result.add(makeUp(strings));
                }
                return;
            }
            if (begin > s.length()) {
                return;
            }
            int i = 1;
            boolean firstIndexZero = false;
            while (i <= 3) {
                // 越界了，return
                if ((begin + i) > s.length()) {
                    return;
                }

                // 如果 第一个位置的值就是0，那么这个逗号内就必须只能是0了
                if (i == 1 && s.charAt(begin) == '0') {
                    firstIndexZero = true;
                }
                if (i <= 1 || !firstIndexZero) {
                    if (Integer.parseInt(s.substring(begin, begin + i)) <= 255) {
                        strings.add(s.substring(begin, begin + i));
                        // 往下走
                        dfs(strings, result, s, begin + i);
                        strings.remove(strings.size() - 1);
                    }
                }
                i++;
            }

        }


    }
}
