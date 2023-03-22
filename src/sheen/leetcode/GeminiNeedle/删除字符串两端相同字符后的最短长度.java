package sheen.leetcode.GeminiNeedle;

/**
 * @Classname 删除字符串两端相同字符后的最短长度
 * @Date 2022/12/28 12:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 删除字符串两端相同字符后的最短长度 {
    public static void main(String[] args) {
        删除字符串两端相同字符后的最短长度 s = new 删除字符串两端相同字符后的最短长度();
        System.out.println(s.minimumLength("abbbbbbbbbbbbbbbbbbba"));
    }
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            int i = left;
            int j = right;

            while (left <= right && s.charAt(i) == s.charAt(left)) {
                left ++;
            }

            if(left > right) {
                return 0;
            }

            while (right >= left && s.charAt(j) == s.charAt(right)) {
                right --;
            }

        }

        return right - left + 1;
    }
}
