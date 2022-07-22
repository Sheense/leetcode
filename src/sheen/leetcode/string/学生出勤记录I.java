package sheen.leetcode.string;

/**
 * @Classname 学生出勤记录I
 * @Date 2021/8/17 12:09 上午
 * @Created by sheen
 * @Description TODO
 */
public class 学生出勤记录I {
    public boolean checkRecord(String s) {
        boolean isL = false;
        int ACount = 0;
        int i = 0;
        while (i < s.length()) {
            if(s.charAt(i) == 'A') ACount++;
            if(s.charAt(i) == 'L' && !isL) {
                int count = 1;
                while (i+1 < s.length() && s.charAt(i + 1) == 'L') {
                    i++;
                    count++;
                }
                if(count >= 3) isL = true;
            }
            i++;
        }
        if(!isL && ACount < 2) {
            return true;
        }
        return false;
    }
}
