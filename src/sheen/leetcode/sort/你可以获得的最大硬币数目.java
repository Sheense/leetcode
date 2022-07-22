package sheen.leetcode.sort;

import java.util.Arrays;

public class 你可以获得的最大硬币数目 {
    public static void main(String[] args) {
        你可以获得的最大硬币数目 s = new 你可以获得的最大硬币数目();
        System.out.println(s.maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));
    }
    public int maxCoins(int[] piles) {
        int res = 0;
        Arrays.sort(piles);
        int end = piles.length-1;
        int n = piles.length/3;
        while(n--!=0) {
            end--;
            res += piles[end--];
        }
        return res;
    }
}
