package sheen.leetcode.string;

/**
 * @Classname 仅仅反转字母
 * @Date 2022/2/23 12:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 仅仅反转字母 {
    public static void main(String[] args) {
        仅仅反转字母 s = new 仅仅反转字母();
        System.out.println(s.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (left < s.length() && (cs[left] < 'a' || cs[left] > 'z') && (cs[left] < 'A' || cs[left] > 'Z') ) {
                left++;
            }

            while (right >= 0 &&  (cs[right] < 'a' || cs[right] > 'z') && (cs[right] < 'A' || cs[right] > 'Z') ) {
                right--;
            }

            if(left <= right) {
                char c = cs[left];
                cs[left] = cs[right];
                cs[right] = c;
                left++;
                right--;
            }
        }
        return String.valueOf(cs);
    }
}
