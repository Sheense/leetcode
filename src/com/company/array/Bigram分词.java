package com.company.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Bigram分词
 * @Date 2021/12/26 1:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class Bigram分词 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] strings = text.split(" ");
        List<String> res = new ArrayList<>();
        for(int i = 0; i < strings.length - 2; i++) {
            if(strings[i].equals(first) && strings[i+1].equals(second)) {
                res.add(strings[i+2]);
            }
        }
        String[] r = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
