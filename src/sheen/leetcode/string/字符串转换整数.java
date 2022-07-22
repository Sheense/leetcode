package sheen.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class 字符串转换整数 {
    public static void main(String[] args) {
        字符串转换整数 s = new 字符串转换整数();
        System.out.println(s.myAtoi("-23 4"));
    }

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        List<Character> list = new ArrayList<>();
        boolean flag = false;
        char fuhao = ' ';
        for(int i=0;i<chars.length;i++) {
            if (chars[i] == ' '){
                if(flag||fuhao!=' ') break;
                continue;
            }
            if(!flag) {
                if ((chars[i]=='+' || chars[i] == '-')  ) {
                    if(fuhao==' ') fuhao = chars[i];
                    else return 0;
                } else if(chars[i]>'0'&&chars[i]<='9') {
                    flag = true;
                    list.add(chars[i]);
                } else if(chars[i]=='0' && (i==chars.length-1 || chars[i+1]<'0' || chars[i]>'9')) return 0;
                else if (chars[i] != ' '&&chars[i] !='0') {
                    return 0;
                }
            } else {
                if (chars[i]>='0'&&chars[i]<='9') {
                    list.add(chars[i]);
                } else {
                    break;
                }
            }
        }
        int jin = 1;
        int res = 0;
        if (list.size()>10) return fuhao=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
        for(int i=list.size()-1;i>=0;i--) {
            if(list.size()==10 && i==0) {
                if(list.get(i)> '2') return fuhao=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
                else if(list.get(i) == '2'){
                   int yushu = Integer.MIN_VALUE % jin;
                   if(-yushu <= res ){
                       if(fuhao=='-') return Integer.MIN_VALUE;
                       return Integer.MAX_VALUE;
                   } else {

                       if(fuhao=='-') return -(res+2*jin);
                       return res+2*jin;
                   }

                }
            }
            res = res + jin*(list.get(i)-'0');
            jin *=10;
        }
        if(fuhao == '-') res = -res;
        return  res;
    }
}
