package sheen.leetcode.string;

/**
 * @Classname 重复叠加字符串匹配
 * @Date 2021/12/22 12:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 重复叠加字符串匹配 {
    public int repeatedStringMatch(String a, String b) {
        if(b.length() == 0) return 0;
        StringBuilder now = new StringBuilder(a);
        int res = 1;
        for(int i = 0; i < a.length(); i++) {
            while (now.length() - i < b.length()) {
                now.append(a);
                res++;
            }
            if(now.toString().substring(i, i + b.length()).equals(b)) {
                return res;
            }
        }
        return -1;
    }
}
