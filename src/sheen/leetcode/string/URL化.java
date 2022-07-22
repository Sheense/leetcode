package sheen.leetcode.string;

public class URL化 {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length()&&length!=0;i++) {
            if(S.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(S.charAt(i));
            }
            length --;
        }
        return sb.toString();
    }
}
