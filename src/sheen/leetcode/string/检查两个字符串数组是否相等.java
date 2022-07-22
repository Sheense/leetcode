package sheen.leetcode.string;

public class 检查两个字符串数组是否相等 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String a = "";
        for(int i=0;i<word1.length;i++) a+= word1[i];
        String b = "";
        for(int i=0;i<word2.length;i++) b+= word2[i];
        return a.equals(b);
    }
}
