package sheen.leetcode.math;

public class 改变一个整数能得到的最大差值 {
    public static void main(String[] args) {
        改变一个整数能得到的最大差值 s = new 改变一个整数能得到的最大差值();
        System.out.println(s.maxDiff(123456));
    }

    public int maxDiff(int num) {
        int w = 0;
        while(num/(int)Math.pow(10,w)!=0) {
            w++;
        }
        int min = -1;
        int n = num;
        int i = w-1;
        while(i>=0) {
            int m = n/(int)Math.pow(10, i);
            if(w-1==i) {
                if(m>1) {
                    min = replace(num, m,1,w);
                    break;
                }
            }else if(m>1){
                min = replace(num, m,0,w);
                break;
            }
            n -= m*(int)Math.pow(10, i);
            i--;
        }
        if(min==-1) min = num;
        int max = -1;
        n = num;
        i = w-1;
        while(i>=0) {
            int m = n/(int)Math.pow(10, i);
            if(m<9) {
                max = replace(num, m,9,w);
                break;
            }
            n -= m*(int)Math.pow(10, i);
            i--;
        }
        if(max == -1) max = num;
        return max-min;
    }

    public int replace(int num, int replaceNum, int targetNum, int w) {
        int res =0;
        int j = w-1;
        int q = num;
        while(j>=0) {
            res *= 10;
            if(q/(int)Math.pow(10,j)==replaceNum) {
                res += targetNum;
            }else {
                res +=(q/(int)Math.pow(10,j));
            }
            q-= (q/(int)Math.pow(10,j)*(int)Math.pow(10,j));
            j--;
        }
        return res;
    }

}
