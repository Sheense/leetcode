package sheen.leetcode.greedyAlgorithm;

/**
 * @Classname 增减字符串匹配
 * @Date 2022/5/9 12:12 上午
 * @Created by sheen
 * @Description TODO
 */
public class 增减字符串匹配 {
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int left = 0;
        int right = s.length() ;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'I') {
                res[i] = left;
                left++;
            }else {
                res[i] = right;
                right--;
            }
        }
        res[s.length()] = left;
        return res;
    }
}
