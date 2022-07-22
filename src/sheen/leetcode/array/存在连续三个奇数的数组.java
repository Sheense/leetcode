package sheen.leetcode.array;

public class 存在连续三个奇数的数组 {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3) return false;
        int index = 0;
        int num = 0;
        while(index<arr.length){
            if(index==0) {
                for(int i=index;i<2&&i<arr.length;i++) {
                    if(arr[index++]%2==1) num++;
                }
            }
            if(arr[index++]%2==1) num++;
            if(num==3) return true;
            if(arr[index-3]%2==1) num--;
        }
        return false;
    }
}
