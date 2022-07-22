package sheen.leetcode.string;

public class 重新排列字符串 {
    public String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()];
        for(int i=0;i<indices.length;i++) {
            res[indices[i]] = s.charAt(i);
        }
        return String.valueOf(res);
    }
}
