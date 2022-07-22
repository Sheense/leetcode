package sheen.leetcode.array;

public class 还原排列的最少操作步数 {
    public static void main(String[] args) {
        还原排列的最少操作步数 s = new 还原排列的最少操作步数();
        System.out.println(s.reinitializePermutation(1000));
    }
    public int reinitializePermutation(int n) {
        int res = 0;
        int[] perm = new int[n];
        for(int i=0;i<perm.length;i++) perm[i] = i;
        do {
            int[] arr = new int[n];
            for(int i=0;i<perm.length;i++) {
                if(i%2==0) {
                    arr[i] = perm[i/2];
                }else {
                    arr[i] = perm[n/2+(i-1)/2];
                }
            }
            perm = arr;
            res++;
        }while (check(perm));
        return res;
    }

    public boolean check(int arr[]) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!=i) return true;
        }
        return false;
    }
}
