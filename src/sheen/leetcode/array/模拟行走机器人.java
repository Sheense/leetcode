package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Classname 模拟行走机器人
 * @Date 2023/7/19 00:12
 * @Created by sheen
 * @Description TODO
 */
public class 模拟行走机器人 {
    public static void main(String[] args) {
        模拟行走机器人 s = new 模拟行走机器人();
        //System.out.println(s.robotSim(new int[]{4,-1,3}, new int[][]{}));
        //System.out.println(s.robotSim(new int[]{4,-1,4,-2,4}, new int[][]{{2, 4}}));
        //System.out.println(s.robotSim(new int[]{6,-1,-1,6}, new int[][]{}));
        System.out.println(s.robotSim(new int[]{-2,-1,-2,3,7}, new int[][]
                {{1,-3},{2,-3},{4,0},{-2,5},{-5,2},{0,0},{4,-4},{-2,-5},{-1,-2},{0,2}}
));
    }
    private int north = 0;
    private int south = 1;
    private int west = 2;
    private int earth = 3;
    public int robotSim(int[] commands, int[][] obstacles) {

        Map<Integer, TreeSet<Integer>> row = new HashMap<>();
        Map<Integer, TreeSet<Integer>> col = new HashMap<>();
        for(int i = 0; i < obstacles.length; i++) {
            row.computeIfAbsent(obstacles[i][0], x -> new TreeSet<>()).add(obstacles[i][1]);
            col.computeIfAbsent(obstacles[i][1], x -> new TreeSet<>()).add(obstacles[i][0]);
        }
        int i = 0;
        int res = 0;
        int d = north;
        int point[] = new int[]{0, 0};
        do{
            if(commands[i] < 0) {
                d = change(d, commands[i++]);
                continue;
            }
            int walk = commands[i++];
            point = walk(d, walk, point, row, col);
            res = Math.max(res, (int)(Math.pow(point[0], 2) + Math.pow(point[1], 2)));
        }while (i < commands.length);
        return res;
    }

    public int[] walk(int d, int len, int[] point, Map<Integer, TreeSet<Integer>> row, Map<Integer, TreeSet<Integer>> col) {
        if(d == west || d == earth) {
            int k = point[1];
            TreeSet<Integer> set = col.getOrDefault(k, new TreeSet<>());
            if(d == earth) {
                int further = point[0] + len;
                Integer val = set.ceiling(point[0] + 1);
                if(val == null || val > further) {
                    point[0] = further;
                }else {
                    point[0] = val - 1;
                }
            }else {
                int further = point[0] - len;
                Integer val = set.floor(point[0] - 1);
                if(val == null || further > val) {
                    point[0] = further;
                }else {
                    point[0] = val + 1;
                }
            }
        }else {
            int k = point[0];
            TreeSet<Integer> set = row.getOrDefault(k, new TreeSet<>());
            if(d == south) {
                int further = point[1] - len;
                Integer val = set.floor(point[1] - 1);
                if(val == null || val < further) {
                    point[1] = further;
                }else {
                    point[1] = val + 1;
                }
            }else {
                int further = point[1] + len;
                Integer val = set.ceiling(point[1] + 1);
                if(val == null || further < val) {
                    point[1] = further;
                }else {
                    point[1] = val - 1;
                }
            }
        }
        return point;
    }

    public int change(int d, int command) {
        if(d == north) {
            if(command == -2) {
                return west;
            }else {
                return earth;
            }
        }else if(d == south) {
            if(command == -2) {
                return earth;
            }else {
                return west;
            }
        }else if(d == west) {
            if(command == -2) {
                return south;
            }else {
                return north;
            }
        }else {
            if(command == -2) {
                return north;
            }else {
                return south;
            }
        }
    }
}
