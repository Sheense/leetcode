package sheen.leetcode.string;

/**
 * @Classname 统计一致字符串的数目
 * @Date 2022/11/8 12:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计一致字符串的数目 {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        for(int i = 0; i < words.length; i++) {
            boolean flag = true;
            for(int j = 0; j < words[i].length(); j++) {
                if(allowed.indexOf(words[i].charAt(j)) == -1) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                res++;
            }
        }
        return res;
    }
}
