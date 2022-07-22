package sheen.leetcode.array;

/**
 * @Classname 重排字符形成目标字符串
 * @Date 2022/5/29 10:32 上午
 * @Created by sheen
 * @Description TODO
 */
public class 重排字符形成目标字符串 {
    public int rearrangeCharacters(String s, String target) {
        int[] all = new int[26];
        for(int i = 0; i < s.length(); i++) {
            all[s.charAt(i) - 'a']++;
        }

        int[] m = new int[26];
        for(int i = 0; i < target.length(); i++) {
            m[target.charAt(i) - 'a']++;
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m.length; i++) {
            if(m[i] > 0) {
                res = Math.min(res, all[i] / m[i]);
            }
        }

        return  res == Integer.MAX_VALUE ? 0 : res;
    }
}
