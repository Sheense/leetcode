package sheen.leetcode.math;

public class 运算 {
    public static void main(String[] args) {
        Operations s = new Operations();
        System.out.println(s.multiply(-8,9));
    }
    static class Operations {

        public Operations() {

        }

        public int minus(int a, int b) {
            return a + (-b);
        }

        public int multiply(int a, int b) {
            if (b == 1) return a;
            if (b == -1) return -a;
            int item = multiply(a, b/2);
            if (minus(Math.abs(b), Math.abs(b/2)) == Math.abs(b/2)) {
                item = item + item;
            }else {
                if (b > 0) {
                    item = item + item + a;
                }else {
                    item = minus(item + item, a);
                }
            }
            return item;
        }

        public int divide(int a, int b) {
            return a /b;
        }
    }
}
