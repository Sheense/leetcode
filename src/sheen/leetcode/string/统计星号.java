package sheen.leetcode.string;

/**
 * @Classname 统计星号
 * @Date 2023/1/29 12:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计星号 {
    public int countAsterisks(String s) {
        int count = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '|') {
                count++;
            }else if(s.charAt(i) == '*' && count % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
