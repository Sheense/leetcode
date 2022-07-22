package sheen.leetcode.string;

public class 字符串压缩 {
    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index<S.length()) {
            int count = 1;
            while (index+1<S.length()&&S.charAt(index) == S.charAt(index+1)) {
                index++;
                count++;
            }
            sb.append(S.charAt(index) + "" + count);
            index++;
        }
        if(sb.length() >= S.length()) return S;
        return sb.toString();
    }
}
