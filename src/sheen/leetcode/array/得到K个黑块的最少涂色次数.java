package sheen.leetcode.array;

/**
 * @Classname 得到K个黑块的最少涂色次数
 * @Date 2023/3/9 12:41 上午
 * @Created by sheen
 * @Description TODO
 */
public class 得到K个黑块的最少涂色次数 {
    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE;
        int[] pre = new int[blocks.length()];
        for(int i = 0; i < blocks.length(); i++) {
            if(i == 0) {
                pre[i] = blocks.charAt(i) == 'B' ? 1 : 0;
            }else {
                pre[i] = pre[i - 1] + (blocks.charAt(i) == 'B' ? 1 : 0);
            }
            if(i == k - 1) {
                min = Math.min(k - pre[i], min);
            }else if(i > k - 1){
                min = Math.min(k - (pre[i] - pre[i - k]), min);
            }
        }
        return min;
    }
}
