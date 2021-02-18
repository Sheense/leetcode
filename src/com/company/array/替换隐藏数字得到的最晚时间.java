package com.company.array;

public class 替换隐藏数字得到的最晚时间 {
    public String maximumTime(String time) {
        String res = "";
        for(int i=0;i<time.length();i++) {
            if(time.charAt(i)=='?') {
                switch (i) {
                    case 0:{
                        if(time.charAt(1)<='3'||time.charAt(1)=='?') {
                            res+='2';
                        }else {
                            res+='1';
                        }
                        break;
                    }
                    case 1: {
                        if(res.charAt(0)<'2') {
                            res+='9';
                        }else {
                            res+= '3';
                        }
                        break;
                    }
                    case 3: {
                        res+='5';
                        break;
                    }
                    case 4: {
                        res+='9';
                        break;
                    }
                }
            }else {
                res+=time.charAt(i);
            }
        }
        return res;
    }
}
