package sheen.leetcode.sort;

import java.util.*;

/**
 * @Classname 奖励最顶尖的K名学生
 * @Date 2023/10/11 00:47
 * @Created by sheen
 * @Description TODO
 */
public class 奖励最顶尖的K名学生 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positiveSet = new HashSet<>();
        Set<String> negativeSet = new HashSet<>();
        for(String item : positive_feedback) {
            positiveSet.add(item);
        }
        for(String item : negative_feedback) {
            negativeSet.add(item);
        }

        int[][] values = new int[report.length][2];
        for(int i = 0; i < report.length; i++) {
            int v = 0;
            for(String item : report[i].split(" ")) {
                if(positiveSet.contains(item)) {
                    v += 3;
                }else if(negativeSet.contains(item)) {
                    v -= 1;
                }
            }
            values[i][0] = v;
            values[i][1] = student_id[i];
        }

        Arrays.sort(values, (x, y) -> {
            if(x[0] > y[0]) {
                return -1;
            }else if(x[0] < y[0]) {
                return 1;
            }else {
                if(x[1] > y[1]) {
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            res.add(values[i][1]);

        }
        return res;
    }
}
