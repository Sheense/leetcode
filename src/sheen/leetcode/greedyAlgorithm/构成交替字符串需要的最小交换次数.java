package sheen.leetcode.greedyAlgorithm;

public class 构成交替字符串需要的最小交换次数 {
    public static void main(String[] args) {

    }
    public int minSwaps(String s) {
        int one = 0;
        int zero = 0;
        boolean flag = true;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '1') one ++;
            if(s.charAt(i) == '0') zero++;
            if(i-1>=0 && s.charAt(i) == s.charAt(i-1)) flag = false;
        }
        if(flag) return 0;
        if(Math.abs(zero-one) > 1) return -1;
        int res = 0;
        char arr[] = s.toCharArray();
        if(zero > one) {
            res = getMinChange(arr, true);
        }else if(zero < one) {
            res = getMinChange(arr, false);
        }else {
            res = Math.min(getMinChange(arr, true), getMinChange(arr, false));
        }
        return res;
    }
    //在达成目的的前提，需要多少词交换
    public int getMinChange(char[] arr, boolean zeroFirst) {
        char[] copy = new char[arr.length];
        for(int i=0;i<arr.length;i++) {
            //0排第一
            if(zeroFirst) {
                if(i%2==0) copy[i] = '0';
                else copy[i] = '1';
            }else {
                if(i%2==0) copy[i] = '1';
                else copy[i] = '0';
            }
        }
        int oneCount = 0;
        int zeroCount = 0;
        int res = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] != copy[i]) {
                if(arr[i] == '1') {
                    if(zeroCount > 0) {
                        zeroCount--;
                    }else {
                        res++;
                        oneCount ++;
                    }
                }else {
                    if(oneCount > 0) {
                        oneCount--;
                    }else {
                        res++;
                        zeroCount ++;
                    }
                }
            }
        }
        return res;
    }
}
