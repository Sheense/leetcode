package com.company.string;

public class 表示数值的字符串 {
    public static void main(String[] args) {
        表示数值的字符串 s = new 表示数值的字符串();
        System.out.println(s.isNumber("1. "));
    }
    public boolean isNumber(String s) {
        String item = s.trim();
        if(item.length()==0) return false;
        int start = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)!=' ') {
                start = i;
                break;
            }
        }
        int end = s.length()-1;
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i)!=' ') {
                end = i;
                break;
            }
        }
        s = s.substring(start, end+1);
        String[] strings = s.split(" ");
        if(strings.length>1) return false;
        s = item;
        if(s.length()==1&&(s.charAt(0)<'0'||s.charAt(0)>'9')) return false;
        boolean hasPoint = false;
        boolean hasE = false;
        boolean hasNum = false;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='+'||c=='-') {
                if(i==0) continue;
                else {
                    if(s.charAt(i-1)=='E'||s.charAt(i-1)=='e') {
                        if(i+1==s.length()||(s.charAt(i+1)<'0'||s.charAt(i+1)>'9')) return false;
                    }else{
                        return false;
                    }
                }
            }else if(c=='.') {
                if(hasPoint) {
                    return false;
                } else {
                    hasPoint=true;
                    if(hasE||i-1>=0&&(s.charAt(i-1)<'0'||s.charAt(i-1)>'9')&&s.charAt(i-1)!='+'&&s.charAt(i-1)!='-') return false;
                    if(i==s.length()-1&&hasNum) return true;
                    if(i==s.length()-1&&!hasNum) return false;
                    if(i+1<s.length()&&(s.charAt(i+1)<'0'||s.charAt(i+1)>'9')&&s.charAt(i+1)!='E'&&s.charAt(i+1)!='e'||hasE) return false;
                    continue;
                }
            }else if(c=='e'||c=='E') {
                if(i+1==s.length()||hasE||i==0)return false;
                if(i-1>=0&&(s.charAt(i-1)<'0'||s.charAt(i-1)>'9')) {
                    if(s.charAt(i-1)!='.') return false;
                    else if(!hasNum)return false;
                }
                hasE = true;
            }else if(c>='0'&&c<='9'){
                hasNum = true;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
