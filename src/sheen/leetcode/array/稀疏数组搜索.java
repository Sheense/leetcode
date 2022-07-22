package sheen.leetcode.array;

public class 稀疏数组搜索 {
    public int findString(String[] words, String s) {
        for(int i=0;i<words.length;i++) {
            if(words.equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
