package com.company.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 独特的电子邮件地址
 * @Date 2022/6/4 11:35 上午
 * @Created by sheen
 * @Description TODO
 */
public class 独特的电子邮件地址 {
    public static void main(String[] args) {
        独特的电子邮件地址 s = new 独特的电子邮件地址();
        System.out.println(s.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"}));
    }
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < emails.length; i++) {
            String[] strs = emails[i].split("@");
            strs[0] = strs[0].replace(".", "");
            int index = strs[0].indexOf('+');
            if(index != -1) {
                strs[0] = strs[0].substring(0, index );
            }
            set.add(strs[0] + "@" + strs[1]);
        }

        return set.size();
    }
}
