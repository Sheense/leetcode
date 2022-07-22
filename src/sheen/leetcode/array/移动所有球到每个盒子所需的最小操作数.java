package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

public class 移动所有球到每个盒子所需的最小操作数 {
    public static void main(String[] args) {
        移动所有球到每个盒子所需的最小操作数 s = new 移动所有球到每个盒子所需的最小操作数();
        ArrayUtils.print(s.minOperations("110"));
    }
    public int[] minOperations(String boxes) {
        if(boxes.length()==0) return new int[]{};
        if(boxes.length()==1) return new int[]{0};
        int [] start = new int[boxes.length()];
        int [] end = new int[boxes.length()];
        for(int i=0;i<boxes.length();i++) {
            for(int j=0;j<i;j++) {
                if(boxes.charAt(j)=='1') {
                    start[i] += (i-j);
                }
            }
            for(int j=boxes.length()-1;j>(boxes.length()-i-1);j--) {
                if(boxes.charAt(j)=='1') {
                    end[boxes.length()-i-1] += (j - (boxes.length()-i-1));
                }
            }
        }
        int [] answer = new int[boxes.length()];
        for(int i=0;i<answer.length;i++) {
            if(i==0) {
                answer[i] = end[i];
            }else if(i==answer.length-1) {
                answer[i] = start[i];
            }else {
                answer[i] = start[i] + end[i];
            }
        }
        return answer;
    }
}
