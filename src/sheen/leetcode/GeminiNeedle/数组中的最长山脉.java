package sheen.leetcode.GeminiNeedle;

public class 数组中的最长山脉 {
    public static void main(String[] args) {
        数组中的最长山脉 s = new 数组中的最长山脉();
        System.out.println(s.longestMountain(new int[]{2,2,2}));
    }
    public int longestMountain(int[] A) {
        int left = -1;
        int right = -1;
        int index = 1;
        int max = 0;
        while(index<A.length) {
            if(A[index-1]<A[index]) {
                if(right==-1&&left==-1) {
                    left = index-1;
                }else if(right!=-1){
                    max = Math.max(max, right-left+1);
                    left = right;
                    right = -1;
                }
            }else if(A[index]<A[index-1]){
                if(left!=-1) {
                    right = index;
                }
            }else if(A[index]==A[index-1]) {
                if(right==-1) {
                    left = -1;
                }else {
                    max = Math.max(max, right-left+1);
                    right = -1;
                    left = -1;
                }
            }
            index++;
        }
        if(left!=-1&&right!=-1) max = Math.max(max, right-left+1);
    return max;





    }
}
