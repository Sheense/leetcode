package sheen.leetcode.bitOperation;

import sheen.leetcode.util.ArrayUtils;

public class 下一个数 {
    public static void main(String[] args) {
        下一个数 s = new 下一个数();
        ArrayUtils.print(s.findClosedNumbers(124));
    }
    public int[] findClosedNumbers(int num) {
        int[] arr = new int[31];
        int n = num;
        for(int i=0;i<arr.length;i++) {
            arr[i] = n % 2;
            n>>=1;
        }
        int [] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int index = 0;
        while (index<arr.length-1) {
            if(arr[index] == 1 && arr[index+1] == 0 && res[0] == -1) {
                res[0] = num - (1<<index) + (1<<(index+1));
                int left = 0;
                int right = index - 1;
                while (left<right) {
                    while (arr[left] == 1&&left!=right) left++;
                    while (arr[right] == 0&&left!=right) right--;
                    if(left!=right&&arr[left] ==0 && arr[right]==1){
                        res[0] = res[0]  - (1<<right) + (1<<left);
                        right--;
                        left++;
                    }
                }
            }
            //找第一个01结构，把index后面的1都排在最前
            if(arr[index] == 0 && arr[index+1] == 1 && res[1] == -1) {
                res[1] = num - (1<<(index+1)) + (1<<index);
                int left = 0;
                int right = index-1;
                while (left<right) {
                    while (arr[left] == 0&&left!=right) left++;
                    while (arr[right] == 1&&left!=right) right--;
                    if(left!=right&&arr[left] == 1 && arr[right]==0){
                        res[1] = res[1] - (1<<left)  + (1<<right);
                        right--;
                        left++;
                    }
                }
            }
            index++;
        }
        return res;
    }
}
