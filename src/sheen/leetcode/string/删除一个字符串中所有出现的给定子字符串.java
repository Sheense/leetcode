package sheen.leetcode.string;

public class 删除一个字符串中所有出现的给定子字符串 {

    public static void main(String[] args) {
        删除一个字符串中所有出现的给定子字符串 s = new 删除一个字符串中所有出现的给定子字符串();
        System.out.println(s.removeOccurrences("axxxxyyyyb", "xy"));
    }
    public String removeOccurrences(String s, String part) {
        int index = s.indexOf(part);
        while (index!=-1) {
            String str = "";
            if(index == 0) {
                str = s.substring(part.length());
            }else if(index + part.length() == s.length()) {
                str = s.substring(0, index);
            }else {
                str = s.substring(0, index) + s.substring(index + part.length());
            }
            s = str;
            index = s.indexOf(part);
        }
        return s;
    }
}
