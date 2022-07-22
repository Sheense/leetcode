package sheen.leetcode.string;

/**
 * @Classname 检测大写字母
 * @Date 2021/11/13 11:45 下午
 * @Created by sheen
 * @Description TODO
 */
public class 检测大写字母 {
    public boolean detectCapitalUse(String word) {
        boolean flag = false;
        for(int i = 0; i < word.length(); i++) {
            if(i == 0) {
                if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    flag = true;
                }
            }else {
                if(!flag) {
                    if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                        return false;
                    }
                }else {
                    if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                        if(i == 1) {
                            flag = false;
                        }else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
