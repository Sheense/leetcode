package sheen.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 唯一摩尔斯密码词
 * @Date 2022/4/10 12:09 上午
 * @Created by sheen
 * @Description TODO
 */
public class 唯一摩尔斯密码词 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
            String str = "";
            for(int j = 0; j < words[i].length(); i++) {
                str += arr[words[i].charAt(j) - 'a'];
            }
            set.add(str);
        }
        return set.size();
    }
}
