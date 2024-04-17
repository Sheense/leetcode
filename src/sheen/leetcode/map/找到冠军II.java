package sheen.leetcode.map;

/**
 * @Classname 找到冠军II
 * @Date 2024/4/13 00:26
 * @Created by sheen
 * @Description TODO
 */
public class 找到冠军II {
    public int findChampion(int n, int[][] edges) {
        int[] count = new int[n];
        for(int[] edge : edges) {
            count[edge[1]]++;
        }
        int res = -1;
        for(int i = 0; i < count.length; i++) {
            if(count[i] == 0) {
                if(res == -1) {
                    res = i;
                }else {
                    return -1;
                }
            }
        }
        return res;
    }
}
