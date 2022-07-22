package sheen.leetcode.bitOperation;

public class 插入 {
    public static void main(String[] args) {
        插入 s = new 插入();
        System.out.println(s.insertBits(1024,19,2,6));
    }

    public int insertBits(int N, int M, int i, int j) {
        int res = 0;
        int index = 0;
        while (index < i) {
            if(N%2==1) {
                res |= (1<<index);
            }
            N>>=1;
            index++;
        }
        while (index>=i && index<=j) {
            if(M%2==1) {
                res |= (1<<index);
            }
            M>>=1;
            N>>=1;
            index++;
        }
        N<<=(j+1);
        return res^N;
    }
}
