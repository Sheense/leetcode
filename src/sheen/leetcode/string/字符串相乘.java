package sheen.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class 字符串相乘 {
    public static void main(String[] args) {
        字符串相乘 s = new 字符串相乘();
        System.out.println(s.multiply("123","456"));
    }
    public String multiply(String num1, String num2) {
        char[] c1 = num1.length()>num2.length()?num1.toCharArray():num2.toCharArray();
        char[] c2 = num1.length()>num2.length()?num2.toCharArray():num1.toCharArray();
        List<List<Character>> list = new ArrayList<>();
        for(int i=c2.length-1;i>=0;i--) {
            int jin = 0;
            List<Character> item = new ArrayList<>();
            for(int j=i;j<c2.length-1;j++) {
                item.add('0');
            }
            for(int j=c1.length-1;j>=0;j--) {
                int r = (c2[i]-'0') * (c1[j]-'0') + jin;
                jin = r/10;
                r = r%10;
                item.add((char)(r+'0'));
            }
            item.add((char)(jin+'0'));
            list.add(item);
        }
        List<Character> res = new ArrayList<>(list.get(0));
        for(int i=1;i<list.size();i++) {
            int jin = 0;
            int j=0;
            for(;j<list.get(i).size();j++) {
                int r = res.size()==j ? list.get(i).get(j)-'0' + jin : res.get(j)+list.get(i).get(j)-2*'0' + jin;
                jin = r/10;
                r = r%10;
                if(res.size()==j){
                    res.add((char)(r+'0'));
                } else {
                    res.set(j, (char)(r+'0'));
                }
            }
            if(res.size()==j) res.add((char)(jin+'0'));
            else {
                for(;j<res.size();j++) {
                    int r = res.get(j) + jin - '0';
                    jin = r/10;
                    r = r%10;
                    res.set(j, (char)r);
                    if(jin==0) break;
                }
            }
        }
        StringBuilder s = new StringBuilder();
        boolean flag = false;
        for(int i=res.size()-1;i>=0;i--){
            if(res.get(i)=='0'&&flag==false) continue;
            s.append(res.get(i));
            flag = true;
        }
        return flag?s.toString():"0";
    }
}
