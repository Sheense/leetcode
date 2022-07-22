package sheen.leetcode.string;

public class 最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        if(s.length()>0) {
            String[] strings = s.split(" ");
            if(strings.length==0) return 0;
            else {
                return strings[strings.length-1].length();
            }
        }
        return 0;
    }
}
