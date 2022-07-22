package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

public class 你能在你最喜欢的那天吃到你最喜欢的糖果吗 {
    public static void main(String[] args) {
        你能在你最喜欢的那天吃到你最喜欢的糖果吗 s = new 你能在你最喜欢的那天吃到你最喜欢的糖果吗();
        ArrayUtils.print(s.canEat(new int[]{46,5,47,48,43,34,15,26,11,25,41,47,15,25,16,50,32,42,32,21,36,34,50,45,46,15,46,38,50,12,3,26,26,16,23,1,4,48,47,32,47,16,33,23,38,2,19,50,6,19,29,3,27,12,6,22,33,28,7,10,12,8,13,24,21,38,43,26,35,18,34,3,14,48,50,34,38,4,50,26,5,35,11,2,35,9,11,31,36,20,21,37,18,34,34,10,21,8,5},
                new int[][]{{85,54,42}}));
    }
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] arr = new long [candiesCount.length];
        for(int i=0;i<candiesCount.length;i++) {
            if(i!=0) {
                arr[i] = arr[i-1] + candiesCount[i];
            }else{
                arr[i] = candiesCount[i];
            }
        }
        boolean[] res = new boolean[queries.length];
        for(int i=0;i<queries.length;i++) {
            int targetDay = queries[i][1]+1;
            int candyType = queries[i][0];
            int daily     = queries[i][2];
            if(candyType-1<0) {
                if (targetDay<=arr[candyType]) {
                    res[i] = true;
                }
            }else {
                long yu = arr[candyType-1]-(targetDay-1);
                if(yu>0) {
                   if(daily>1) {
                       long n = yu/(daily-1);
                       if(n<targetDay-1) {
                           res[i] = true;
                       }else if(n==(targetDay-1)){
                           long mod = yu%(daily-1);
                           if(mod<daily){
                               res[i] = true;
                           }
                       }else {
                           long q = yu%(daily-1) + (n - (targetDay-1)) * (daily-1);
                           if(q<daily) {
                               res[i] = true;
                           }
                       }
                   }
                }else if(yu<0) {
                    if(arr[candyType]>=targetDay) {
                        res[i] = true;
                    }
                }else {
                    res[i] = true;
                }
            }
        }
        return res;
    }
}
