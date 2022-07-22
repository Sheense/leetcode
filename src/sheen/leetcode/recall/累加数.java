package sheen.leetcode.recall;

/**
 * @Classname 累加数
 * @Date 2022/1/10 12:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class 累加数 {
    public static void main(String[] args) {
        累加数 s = new 累加数();
        System.out.println(s.isAdditiveNumber("0235813"));
    }
    public boolean isAdditiveNumber(String num) {
        return recall(num, 0, 0, 0 );
    }

    public boolean recall(String num, int index, long a, long b) {
        if(index >= num.length()) {
            return false;
        }
        if(index == 0) {
            for(int i = index; i < num.length() / 2; i++) {
                if(i > index && num.charAt(index) == '0') {
                    break;
                }
                long n = Long.valueOf(num.substring(index, i + 1));
                if(num.charAt(i + 1) == '0') {
                    long m = 0;
                    boolean res = recall(num, i + 2, n, m);
                    if(res) {
                        return res;
                    }
                }else {
                    for(int j = i + 1; j < (num.length() - i - 1) / 2 + i + 1; j++) {
                        long m = Long.valueOf(num.substring(i+1, j + 1));
                        boolean res = recall(num, j + 1, n, m);
                        if(res) {
                            return res;
                        }
                    }
                }
            }
        }else {
            long and = a + b;
            String str = String.valueOf(and);
            int end = Math.min(index + str.length(), num.length());
            String next = num.substring(index, end);
            if(str.equals(next)) {
                if(index + str.length() == num.length()) {
                    return true;
                }
                boolean res = recall(num, end, b, Long.valueOf(next));
                if(res) {
                    return res;
                }
            }

        }
        return false;
    }
}
