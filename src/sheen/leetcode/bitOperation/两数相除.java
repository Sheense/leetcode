package sheen.leetcode.bitOperation;

public class 两数相除 {
    public static void main(String[] args) {
        两数相除 s = new 两数相除();
        System.out.println(s.divide(Integer.MIN_VALUE,2));
    }

    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1) return (1<<31)-1;
        if(dividend==Integer.MIN_VALUE&&divisor==1) return dividend;
        if(dividend==Integer.MIN_VALUE&&divisor == Integer.MIN_VALUE) return 1;
        if(divisor==Integer.MIN_VALUE) return 0;
        boolean flag = false;
        if(dividend==Integer.MIN_VALUE) {
            dividend ++;
            flag = true;
        }
        int beichushu = dividend>=0 ? dividend : (~dividend)+1;
        int chushu = divisor>=0 ? divisor : (~divisor)+1;
        int shang = 0;
        for (int i = 31;i>=0;i--) {
            if((beichushu>>i)>=chushu) {
                beichushu = add(beichushu, (~(chushu<<i))+1);
                shang = add(shang, 1<<i);
            }
        }
        if(flag&&(beichushu+1)>=chushu) {
            shang = add(shang, 1);
        }
        return (dividend^divisor)<0?(~shang)+1:shang;
    }
    public int add (int v1,int v2) {
        int carry = (v1&v2)<<1;
        int result = v1^v2;
        while(carry!=0) {
            int item1 = (carry&result)<<1;
            int item2 = carry^result;
            carry = item1;
            result = item2;
        }
        return result;
    }

}
