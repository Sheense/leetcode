package sheen.leetcode.array;

/**
 * @Classname 得到更多分数的最少关卡数目
 * @Date 2024/7/19 00:41
 * @Created by sheen
 * @Description TODO
 */
public class 得到更多分数的最少关卡数目 {
    public static void main(String[] args) {
        得到更多分数的最少关卡数目 s = new 得到更多分数的最少关卡数目();
        System.out.println(s.minimumLevels(new int[]{1, 1}));
    }
    public int minimumLevels(int[] possible) {
        for(int i = 0; i < possible.length; i++) {
            possible[i] = possible[i] == 0 ? -1 : 1;
            if(i != 0) {
                possible[i] += possible[i - 1];
            }
        }

        for(int i = 0; i < possible.length - 1; i++) {
            if(possible[i] > possible[possible.length - 1] - possible[i]) {
                return i + 1;
            }
        }

        return -1;
    }
}
