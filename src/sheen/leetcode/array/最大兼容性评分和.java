package sheen.leetcode.array;

/**
 * @Classname 最大兼容性评分和
 * @Date 2021/7/25 11:27 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大兼容性评分和 {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] check = new boolean[students.length];
        recall(students, mentors, 0, check, 0);
        return res;
    }

    int res = 0;
    public void recall(int[][] students, int[][] mentors, int index, boolean[] check, int count) {
        if(index == students.length) {
            res = Math.max(res, count);
        }
        for(int i = 0; i< check.length; i++) {
            if(!check[i]) {
                int c = 0;
                for(int j = 0; j < mentors[i].length; j++) {
                    if(mentors[i][j] == students[index][j]) {
                        c++;
                    }
                }
                check[i] = true;
                recall(students, mentors, index+1, check, count+c);
                check[i] = false;
            }
        }
    }
}

