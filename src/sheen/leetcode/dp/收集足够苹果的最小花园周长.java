package sheen.leetcode.dp;

/**
 * @Classname 收集足够苹果的最小花园周长
 * @Date 2021/8/1 2:04 下午
 * @Created by sheen
 * @Description TODO
 */
public class 收集足够苹果的最小花园周长 {
    public static void main(String[] args) {
        收集足够苹果的最小花园周长 s = new 收集足够苹果的最小花园周长();
        System.out.println(s.minimumPerimeter(344));
    }
    public long minimumPerimeter(long neededApples) {
        long last = 0;
        long sum = 0;
        long i = 1;
        while (true) {
            if(i == 1) {
                last = 2 * 1 * 4 +4;
                sum += last;
            }else {
                long now = 2 * i * 4 + last + 2 * (i-1) * 4 + 4 + 2 * (i-1) * 4;
                sum += now;
                last = now;
            }
            if(neededApples <= sum) return i * 2 * 4;
            i++;
        }
    }
}
