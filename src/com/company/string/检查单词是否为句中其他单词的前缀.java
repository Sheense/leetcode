package com.company.string;

public class 检查单词是否为句中其他单词的前缀 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        int now = 0;
        String[] strings = sentence.split(" ");
        for(int i=0;i<strings.length;i++) {
            if(strings[i].length()>=searchWord.length()&&strings[i].substring(0,searchWord.length()).equals(searchWord)) {
                return i+1;
            }
        }
        return -1;
    }
}
