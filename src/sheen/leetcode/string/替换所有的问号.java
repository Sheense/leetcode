package sheen.leetcode.string;

public class 替换所有的问号 {
    public static void main(String[] args) {
        替换所有的问号 s = new 替换所有的问号();
        System.out.println(s.modifyString("?"));
    }
    public String modifyString(String s) {
        String res = "";
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='?') {
                for(int j=0;j<26;j++) {
                    if(i-1>=0&&i+1<s.length()) {
                        if (res.charAt(i - 1) != ('a' + j) && s.charAt(i + 1) != ('a'+j)) {
                            res+=(char)('a'+j);
                            break;
                        }
                    }else if(i-1>=0) {
                        if(res.charAt(i - 1) != ('a' + j)) {
                            res+=(char)('a'+j);
                            break;
                        }
                    }else if(i+1<s.length()) {
                        if(s.charAt(i + 1) != ('a' + j)) {
                            res+=(char)('a'+j);
                            break;
                        }
                    }else {
                        res+='a';
                        break;
                    }
                }
            }else {
                res += s.charAt(i);
            }
        }
        return res;
    }
}
