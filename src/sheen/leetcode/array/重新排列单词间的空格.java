package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class 重新排列单词间的空格 {
    public static void main(String[] args) {
        重新排列单词间的空格 s = new 重新排列单词间的空格();
        System.out.println(s.reorderSpaces("  hello"));
    }
    public String reorderSpaces(String text) {
        int num = 0;
        for(int i=0;i<text.length();i++) {
            if(text.charAt(i)==' ') num++;
        }
        if(num==0) return text;
        String[] strings = text.split(" ");
        List<String> list = new ArrayList<>();
        for(int i=0;i<strings.length;i++) {
            if(!strings[i].equals("")) list.add(strings[i]);
        }
        String res = "";
        if(list.size()==1) {
            res += list.get(0);
            for(int i=0;i<num;i++) {
                res +=' ';
            }
            return res;
        }
        int part = num/(list.size()-1);
        int yu = num%(list.size()-1);
        for(int i=0;i<list.size();i++) {
            if(i!=list.size()-1) {
                res += list.get(i);
                for(int j=0;j<part;j++) {
                    res += " ";
                }
            }else {
                res += list.get(i);
                for(int j=0;j<yu;j++) {
                    res += " ";
                }
            }
        }
        return res;
    }
}
