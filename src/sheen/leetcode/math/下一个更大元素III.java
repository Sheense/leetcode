package sheen.leetcode.math;

public class 下一个更大元素III {
    public static void main(String[] args) {
        下一个更大元素III s = new 下一个更大元素III();
        System.out.println(s.nextGreaterElement(11112));
    }
    public int nextGreaterElement(int n) {
        int arr[] = new int[10];
        char[] s = String.valueOf(n).toCharArray();
        for(int i=s.length-1;i>=0;i--) {
            arr[s[i] - '0']++;
            int target = search(s[i] - '0' + 1, arr);
            if(target != -1) {
                arr[target]--;
                s[i] = (char)(target + '0');
                for(int j=0;j<arr.length;j++) {
                    while(arr[j]!=0) {
                        s[++i] = (char)(j + '0');
                        arr[j]--;
                    }
                }
                long res = Long.parseLong(String.valueOf(s));
                if(res <= Integer.MAX_VALUE) {
                    return (int)res;
                }
                return -1;
            }
        }
        return -1;
    }

    public int search(int i, int [] arr) {
        for(;i<arr.length;i++) {
            if(arr[i]!=0) {
                return i;
            }
        }
        return -1;
    }
}
