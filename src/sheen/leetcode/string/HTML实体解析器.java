package sheen.leetcode.string;

public class HTML实体解析器 {
    public static void main(String[] args) {
        HTML实体解析器 s = new HTML实体解析器();
        System.out.println(s.entityParser("leetcode.com&frasl;problemset&frasl;all"));
    }

    public String entityParser(String text) {
        StringBuilder res = new StringBuilder();
        int i=0;
        while(i<text.length()) {
            if(text.charAt(i)=='&') {
                int j = i+1;
                while(j<text.length()&&j-i<=6&&text.charAt(j)!='&'&&text.charAt(j)!=';') {
                    j++;
                }
                if(j==text.length()||text.charAt(j)=='&'||j-i>6) {
                    res.append(text.substring(i,j));
                    i = j;
                } else {//if(text.charAt(j)==';')
                    switch (text.substring(i,j+1)) {
                        case "&quot;" : res.append("\"");break;
                        case "&apos;" : res.append("'");break;
                        case "&amp;": res.append("&");break;
                        case "&gt;": res.append(">");break;
                        case "&lt;": res.append("<");break;
                        case "&frasl;": res.append("/");break;
                        default: res.append(text.substring(i,j+1));
                    }
                    i = j+1;
                }
            }else {
                res.append(text.charAt(i));
                i++;
            }
        }
        return res.toString();
    }

}
