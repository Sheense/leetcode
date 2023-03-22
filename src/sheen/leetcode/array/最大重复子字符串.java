package sheen.leetcode.array;

/**
 * @Classname 最大重复子字符串
 * @Date 2022/11/3 12:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大重复子字符串 {
    public static void main(String[] args) {
        最大重复子字符串 s = new 最大重复子字符串();
        System.out.println(s.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }
    public int maxRepeating(String sequence, String word) {
        int max = 0;
        int i = 0;
        int len = word.length();
        while (i < sequence.length() - word.length() + 1) {
            int next = i + 1;
            int start = i;
            int count = 0;
            while (start + len <= sequence.length() && sequence.substring(start, start + len).equals(word)) {
                start += len;
                count++;
            }
            i = next;
            max = Math.max(max, count);
        }
        return max;
    }
}
