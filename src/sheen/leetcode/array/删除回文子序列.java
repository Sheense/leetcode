package sheen.leetcode.array;

/**
 * @Classname 删除回文子序列
 * @Date 2022/1/22 1:41 下午
 * @Created by sheen
 * @Description TODO
 */
public class 删除回文子序列 {
    public int removePalindromeSub(String s) {
        boolean flag = true;
        for(int i = 0; i < s.length() / 2; i ++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                flag = false;
                break;
            }
        }
        if(flag) {
            return 1;
        }
        return 2;
    }
}
