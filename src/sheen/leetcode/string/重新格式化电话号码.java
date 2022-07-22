package sheen.leetcode.string;

public class 重新格式化电话号码 {
    public String reformatNumber(String number) {
        String n = "";
        for(int i=0;i<number.length();i++) {
            if(number.charAt(i)!='-'&&number.charAt(i)!=' ') {
                n += number.charAt(i);
            }
        }
        int time = n.length()/3;
        int last = 0;
        if(n.length()%3==1) {
            last = 4;
            time --;
        }else if(n.length()%3==2) {
            last =2;
        }
        String res  = "";
        int start = 0;
        while(time-->0) {
            res += n.substring(start, start+3) + "-";
            start+=3;
        }
        if(last==0) {
            res = res.substring(0, res.length()-1);
        }else if(last==2) {
            res += n.substring(start, start+2);
        }else if(last==4) {
            res += n.substring(start, start+2) +'-'+n.substring(start+2, start+4);
        }
        return res;
    }
}
