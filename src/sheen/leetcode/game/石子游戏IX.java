package sheen.leetcode.game;

/**
 * @Classname 石子游戏IX
 * @Date 2022/1/20 12:33 上午
 * @Created by sheen
 * @Description TODO
 */
public class 石子游戏IX {
    public static void main(String[] args) {
        石子游戏IX s = new 石子游戏IX();
        System.out.println(s.stoneGameIX(new int[]{2, 2, 3}));
    }
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for(int i = 0; i < stones.length; i++) {
            count[stones[i] % 3] ++;
        }

        if(count[0] % 2 == 0) {
            return count[1] >= 1 && count[2] >= 1;
        }else {
            return (count[1] > count[2] + 2) || (count[2] > count[1] + 2);
        }
    }
}
