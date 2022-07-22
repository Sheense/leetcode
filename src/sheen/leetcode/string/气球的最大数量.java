package sheen.leetcode.string;

/**
 * @Classname 气球的最大数量
 * @Date 2022/2/13 1:01 下午
 * @Created by sheen
 * @Description TODO
 */
public class 气球的最大数量  {
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[26];
        for(int i = 0; i < text.length(); i++) {
            arr[text.charAt(i) - 'a']++;
        }
        char[] m = new char[]{'b','a', 'l','o','n'};
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m.length; i++) {
            if(m[i] == 'l' || m[i] == 'o') {
                res = Math.min(arr[m[i] - 'a'] / 2, res);
            }else {
                res = Math.min(arr[m[i] - 'a'], res);
            }
        }
        return res;
    }
}
