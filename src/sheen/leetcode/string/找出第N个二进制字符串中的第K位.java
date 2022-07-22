package sheen.leetcode.string;

public class 找出第N个二进制字符串中的第K位 {
    public static void main(String[] args) {
        找出第N个二进制字符串中的第K位 s= new 找出第N个二进制字符串中的第K位();
        System.out.println(s.findKthBit(6,58));
    }
    public char findKthBit(int n, int k) {
        if(k==1) return '0';
        int m = 0;
        while(Math.pow(2,m+1)<=k) {
            m++;
        }
        if(Math.pow(2,m)==k) {
            return '1';
        }
        int time = 0;
        while(k>3) {
            int item = k- (int)Math.pow(2,m);
            k = (int)Math.pow(2,m) - item;
            do {
                m--;
            }while((int)Math.pow(2,m)>k);
            time++;
        }
        if(k==1) {
            if(time%2==0) {
                return '0';
            }else{
                return '1';
            }
        }else {
            if(time%2==0) {
                return '1';
            }else{
                return '0';
            }
        }
    }
}
