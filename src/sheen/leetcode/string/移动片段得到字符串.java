package sheen.leetcode.string;

import java.util.TreeSet;

/**
 * @Classname 移动片段得到字符串
 * @Date 2023/8/21 00:10
 * @Created by sheen
 * @Description TODO
 */
public class 移动片段得到字符串 {
    public static void main(String[] args) {
        移动片段得到字符串 s= new 移动片段得到字符串();
        System.out.println(s.canChange("_R", "R_"));
    }
    public boolean canChange(String start, String target) {
        TreeSet<Integer> lSet = new TreeSet<>();
        TreeSet<Integer> rSet = new TreeSet<>();
        String a = "";
        String b = "";
        for(int i = 0; i < start.length(); i++) {
            if(start.charAt(i) == 'L') {
                lSet.add(i);
                a += "L";
            }else if(start.charAt(i) == 'R'){
                rSet.add(i);
                a += "R";
            }

            if(target.charAt(i) == 'L') {
                b += "L";
            }else if(target.charAt(i) == 'R') {
                b += "R";
            }
        }
        if(!a.equals(b)) {
            return false;
        }

        int i = target.length() - 1;
        TreeSet<Integer> copyR = new TreeSet<>(rSet);
        while (i >= 0) {
            while (i >= 0 && target.charAt(i) != 'R') {
                i--;
            }
            if(i < 0) {
                break;
            }
            Integer lInx = lSet.floor(i);
            Integer rInx = copyR.floor(i);
            if(rInx == null || (lInx != null && rInx < lInx)) {
                return false;
            }
            copyR.remove(rInx);
            i--;
        }

        i = 0;
        TreeSet<Integer> copyL = new TreeSet<>(lSet);
        while (i < target.length()) {
            while (i < target.length() && target.charAt(i) != 'L') {
                i++;
            }
            if(i >= target.length()) {
                break;
            }

            Integer lInx = copyL.ceiling(i);
            Integer rInx = rSet.ceiling(i);
            if(lInx == null || (rInx != null && lInx > rInx)) {
                return false;
            }
            copyL.remove(lInx);
            i++;
        }

        return true;
    }
}
