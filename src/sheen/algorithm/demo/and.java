package sheen.algorithm.demo;

/**
 * @Classname and
 * @Date 2023/3/23 12:18 下午
 * @Created by sheen
 * @Description TODO
 */
public class and {
    public static void main(String[] args) {
        System.out.println(adds(111, 11));
    }

    public static int adds(int a, int b) {
        int v = a ^ b;
        int next = (a & b) << 1;
        if(next == 0) {
            return v;
        }
        return adds(v, next);
    }
}
