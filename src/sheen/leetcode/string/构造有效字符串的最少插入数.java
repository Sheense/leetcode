package sheen.leetcode.string;

/**
 * @Classname 构造有效字符串的最少插入数
 * @Date 2024/1/11 00:30
 * @Created by sheen
 * @Description TODO
 */
public class 构造有效字符串的最少插入数 {
    public int addMinimum(String word) {
        int count = 0;
        int i = 0;
        char pre = 'c';

        while (i < word.length()) {
            if(word.charAt(i) == 'a') {
                if(pre == 'a') {
                    count+=2;
                }else if(pre == 'b') {
                    count++;
                }
                pre = 'a';
            }else if(word.charAt(i) == 'b') {
                if(pre == 'b') {
                    count+=2;
                }else if(pre == 'c') {
                    count++;
                }
                pre = 'b';
            }else if(word.charAt(i) == 'c') {
                if(pre == 'a') {
                    count++;
                }else if(pre == 'c') {
                    count+=2;
                }
                pre = 'c';
            }
            i++;
        }
        if(pre == 'b') {
            count++;
        }else if(pre == 'a') {
            count+=2;
        }
        return count;
    }
}
