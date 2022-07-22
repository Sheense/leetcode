package sheen.leetcode.string;

import java.util.Random;

/**
 * @Classname 删除字符使字符串变好
 * @Date 2021/8/7 10:37 下午
 * @Created by sheen
 * @Description TODO
 */
public class 删除字符使字符串变好 {
    public static void main(String[] args) {
        删除字符使字符串变好 s = new 删除字符使字符串变好();
        Random rand=new Random();
        String str = "";
        for(int i = 0; i < 10000; i++) {
            char c=(char)(rand.nextInt(26)+'a');
            str += c;
        }
        System.out.println(str);
        System.out.println(s.makeFancyString(str));
    }
    public String makeFancyString(String s) {
        int index = 0;
        StringBuffer res = new StringBuffer("");
        String str = "";
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0) {
                count = 1;
            }else {
                if(s.charAt(i) == s.charAt(i-1)) {
                    count++;
                }else {
                    count=1;
                }
            }
            if(count <= 2) {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}
