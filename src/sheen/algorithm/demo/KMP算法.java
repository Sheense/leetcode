package sheen.algorithm.demo;

/**
 * @Classname KMP算法
 * @Date 2023/3/24 1:18 上午
 * @Created by sheen
 * @Description TODO
 */
public class KMP算法 {
    public static void main(String[] args) {

    }

    //abcabc 最后一个c匹配不上了，会找一下前缀
    //求next数组
    public static int[] getNext(String str) {
        int[] next = new int[str.length() + 1];
        next[0] = -1;
        for(int i = 1; i < next.length; i++) {
            int index = next[i - 1];
            while (index != -1 && str.charAt(next[index]) != str.charAt(i - 1)) {
                index = next[index];
            }
            next[i] = index + 1;
        }

        return next;
    }
}
