package sheen.leetcode.list;

import sheen.leetcode.util.ArrayUtils;

public class 查询带键的排列 {

    public static void main(String[] args) {
        查询带键的排列 s = new 查询带键的排列();
        ArrayUtils.print(s.processQueries(new int []{1,2,1}, 3));
    }

    public int[] processQueries(int[] queries, int m) {
        int [] arr = new int[m+queries.length];
        int index = 1;
        for(int j=queries.length;j<arr.length;j++) {
            arr[j] = index;
            index++;
        }
        int [] res = new int[queries.length];
        int start = 0;
        for(int i=0;i<queries.length;i++) {
            int index1 = 0;
            for(int j=0;j<arr.length;j++) {
                if(arr[j]==0)continue;
                if(arr[j]==queries[i]) {
                    res[i] = index1;
                    if(j<start){
                        int z=j-1;
                        int item = arr[j];
                        while(z>=0) {
                            arr[z+1] = arr[z];
                            z--;
                        }
                        arr[0] = item;
                    }else {
                        arr[start] = arr[j];
                        int z=start-1;
                        int item = arr[j];
                        while(z>=0) {
                            arr[z+1] = arr[z];
                            z--;
                        }
                        arr[0] = item;
                        arr[j] = 0;
                        start++;
                    }
                    break;
                }else {
                    index1++;
                }
            }
        }
        return res;
    }
}
