package sheen.leetcode.window;

/**
 * @Classname 单字符重复子串的最大长度
 * @Date 2023/6/3 2:04 下午
 * @Created by sheen
 * @Description TODO
 */
public class 单字符重复子串的最大长度 {
    public static void main(String[] args) {
        单字符重复子串的最大长度 s = new 单字符重复子串的最大长度();
        System.out.println(s.maxRepOpt1("aabaaabaaaba"));
    }
    public int maxRepOpt1(String text) {
        int[] count = new int[26];
        for(int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;
        int ans = 1;
        while (left < text.length()) {
            boolean flag = true;
            int c = count[text.charAt(left) - 'a'];
            int next = -1;
            while (right < text.length() && ((text.charAt(left) == text.charAt(right) || flag) && c > 0 )) {
                if(text.charAt(left) != text.charAt(right)) {
                    flag = false;
                    next = right;
                }
                c--;
                right++;
            }
            //情况：abcaaa
            if(right == text.length() && c > 0 && flag) {
                ans = Math.max(ans, right - left + 1);
            }else {
                ans = Math.max(ans, right - left);
            }
            //情况：aabaaabaaaba
            if(next != -1) {
                left = next;
                right = next;
            }else {
                left = right;
            }
        }
        return ans;
    }
}
