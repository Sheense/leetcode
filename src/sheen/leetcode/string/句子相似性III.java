package sheen.leetcode.string;

import java.util.Arrays;

/**
 * @Classname 句子相似性III
 * @Date 2023/1/16 12:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 句子相似性III {
    public static void main(String[] args) {
        句子相似性III s = new 句子相似性III();
        System.out.println(s.areSentencesSimilar("eTUny i b R UFKQJ EZx JBJ Q xXz", "eTUny i R EZx JBJ xXz"));
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] str1 = sentence1.split(" ");
        String[] str2 = sentence2.split(" ");

        if(str1.length > str2.length) {
            return is(str1, str2, sentence1, sentence2);
        }

        return is(str2, str1, sentence2, sentence1);
    }

    public boolean is(String[] str1, String[] str2, String sentence1, String sentence2) {
        if(!str1[0].equals(str2[0])) {
            int i = str1.length - 1;
            int j = str2.length - 1;
            for(; j >= 0; j--) {
                if(!str2[j].equals(str1[i])) {
                    break;
                }else {
                    i--;
                }
            }

            return j < 0;
        }

        if(!str1[str1.length - 1].equals(str2[str2.length - 1])) {
            int i = 0;
            int j = 0;
            for(; j < str2.length; j++) {
                if(!str2[j].equals(str1[i])) {
                    break;
                }else {
                    i++;
                }
            }

            return j >= str2.length;
        }

        int i1 = 0;
        int i2 = str1.length - 1;
        int j1 = 0;
        int j2 = str2.length - 1;
        while (j1 <= j2) {
            if(str1[i1].equals(str2[j1])) {
                i1++;
                j1++;
            }else {
                break;
            }
        }

        while (j2 >= j1) {
            if(str1[i2].equals(str2[j2])) {
                i2--;
                j2--;
            }else {
                break;
            }
        }

        return j2 < j1;


    }

}
