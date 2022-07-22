package sheen.leetcode.string;

/**
 * @Classname 亲密字符串
 * @Date 2021/11/23 12:22 上午
 * @Created by sheen
 * @Description TODO
 */
public class 亲密字符串 {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int[] arr = new int[2];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                if(index >= 2) return false;
                arr[index++] = i;
            }
        }
        if(index == 0) {
            int[] a = new int[26];
            for(int i = 0; i < s.length(); i++) {
                a[s.charAt(i) - 'a']++;
            }
            boolean flag = false;
            for(int i = 0; i < a.length; i++) {
                if(a[i] > 1) {
                    flag = true;
                    break;
                }
            }
            return flag;
        }

        return s.charAt(arr[0]) == goal.charAt(arr[1]) && s.charAt(arr[1]) == goal.charAt(arr[0]);
    }
}
