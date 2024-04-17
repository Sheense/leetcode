package sheen.leetcode.array;

/**
 * @Classname 最多可以摧毁的敌人城堡数目
 * @Date 2023/9/2 00:10
 * @Created by sheen
 * @Description TODO
 */
public class 最多可以摧毁的敌人城堡数目 {
    public int captureForts(int[] forts) {
        int start = Integer.MAX_VALUE;
        int count = 0;
        int max = 0;
        for(int i = 0; i < forts.length; i++) {
            if(forts[i] == 0) {
                if(start == Integer.MAX_VALUE) {
                    continue;
                }
            }else {
                if(start == Integer.MAX_VALUE) {
                    start = forts[i];
                    continue;
                }
            }
            if(forts[i] == 0) {
                count++;
            }else {
                if((forts[i] == -1 && start == 1) || (forts[i] == 1 && start == -1)) {
                    max = Math.max(max, count);
                    count = 0;
                    start = 1;
                }else {
                    start = forts[i];
                    count = 0;
                }
            }
        }
        return max;
    }
}
