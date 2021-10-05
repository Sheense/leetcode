package com.company.test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname 正则测试
 * @Date 2021/9/23 11:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 正则测试 {
    /*public static void main(String[] args) {
        Pattern logPattern = Pattern.compile("\\{\\}");
        Matcher matcher = logPattern.matcher("a{}b{}c{}d{}cccc");
        List<String> list = Arrays.asList("a", "b", "c", "d");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (matcher.find()) {
            matcher.appendReplacement(sb, list.get(i++));
            System.out.println(sb);
        }
        matcher.appendTail(sb);
        System.out.println(sb);
    }*/
    public static void main(String[] args) {
        int ACount1 = 0;
        int ACount2 = 0;
        int BCount1 = 0;
        int BCount2 = 0;
        for(int i = 0; i < 100000; i++) {
            String gid = getRandomString();
            int value = dJBHash1("rankerABTest" + gid);
            if(value <= 50) {
                value = dJBHash1("slidingDisplay" + gid);
                if(value < 20) {
                    ACount1++;
                }else {
                    ACount2++;
                }
            }else {
                value = dJBHash1("slidingDisplay" + gid);
                if(value < 20) {
                    BCount1++;
                }else {
                    BCount2++;
                }
            }
        }
        System.out.println("A：C=" + ACount1);
        System.out.println("A：D=" + ACount2);
        System.out.println("B：C=" + BCount1);
        System.out.println("B：D=" + BCount2);


        System.out.println("a".substring(1 - 2));
    }

    private static int dJBHash1(String str) {
        int hash = 5381;
        char[] charList = str.toCharArray();
        for (int i = 0; i < charList.length; i++) {
            hash += (hash << 5) + charList[i];
        }
        hash = hash & 0x7FFFFFFF;
        String hashStr = String.valueOf(hash);
        if(hashStr.length() <= 2) {
            return Integer.parseInt(hashStr);
        }
        return Integer.parseInt(hashStr.substring(hashStr.length() - 2));
    }

    public static String getRandomString() {
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        String res = "";
        Random random = new Random();
        for(int i = 0; i < 32; i++) {
            int index = random.nextInt(62);
            res += str.charAt(index);
        }
        return res;
    }
}
