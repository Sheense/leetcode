package com.company.recall;

import com.company.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址 {
    public static void main(String[] args) {
        复原IP地址 s = new 复原IP地址();
        ArrayUtils.print(s.restoreIpAddresses("010010"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        recall(s, 0, new StringBuilder(), 0, res);
        return res;
    }

    public void recall(String s, int index, StringBuilder now, int point,List<String> res) {
        if(point==1&&s.length()-index>=10) {
            return;
        }
        if(point==2&&s.length()-index>=7){
            return;
        }
        if(point==3){
            if(s.length()-index<=3&&s.length()-index>0&&isIp(s.substring(index))) {
                String string = new StringBuilder(now).append(s.substring(index)).toString();
                res.add(string);
            }
            return;
        }
        for(int i=1;i<=3;i++) {
            if(i+index>s.length()) continue;
            String ip = s.substring(index, i+index);
           if(isIp(ip)) {
               StringBuilder stringBuilder = new StringBuilder(now).append(ip).append('.');
               recall(s, index+i, stringBuilder, point+1, res);
               if(i==1&&ip.equals("0")) break;
           }
        }
    }

    public boolean isIp(String string) {
        char[] chars = string.toCharArray();
        int n = 0;
        if(chars.length==3) {
            n = (chars[0]-'0')*100 + (chars[1]-'0')*10 + chars[2] - '0';
        }else if(chars.length==2) {
            n = (chars[0]-'0')*10 + chars[1] - '0';
        }else {
            n = chars[0] - '0';
        }
        if(chars.length==2&&n<10) return false;
        if(chars.length==3&&n<100) return false;
        if(n<=255) return true;
        else return false;
    }
}
