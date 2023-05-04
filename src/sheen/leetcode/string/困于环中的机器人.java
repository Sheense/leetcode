package sheen.leetcode.string;

/**
 * @Classname 困于环中的机器人
 * @Date 2023/4/11 12:20 上午
 * @Created by sheen
 * @Description TODO
 */
public class 困于环中的机器人 {
    public static void main(String[] args) {
        困于环中的机器人 s = new 困于环中的机器人();
        System.out.println(s.isRobotBounded("GL"));
    }
    int[][] map = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean isRobotBounded(String instructions) {
        int i = 0;
        int j = 0;
        int now = 1;

        int[] res = walk(i, j, instructions, now);
        if(res[0] == 0 && res[1] == 0) {
            return true;
        }


        return res[2] != 1;
    }

    public int[] walk(int i, int j, String instructions, int now) {
        for(char c : instructions.toCharArray()) {
            if(c == 'G') {
                i += map[now][0];
                j += map[now][1];
            }else if(c == 'L') {
                if(now == 0) {
                    now = 1;
                }else if(now == 1) {
                    now = 2;
                }else if(now == 2) {
                    now = 3;
                }else {
                    now = 0;
                }
            }else {
                if(now == 0) {
                    now = 4;
                }else if(now == 1) {
                    now = 0;
                }else if(now == 2) {
                    now = 1;
                }else {
                    now = 2;
                }
            }
        }
        return new int[]{i, j, now};
    }
}
