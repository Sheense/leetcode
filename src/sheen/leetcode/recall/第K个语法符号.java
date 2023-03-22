package sheen.leetcode.recall;

/**
 * @Classname 第K个语法符号
 * @Date 2022/10/20 1:09 上午
 * @Created by sheen
 * @Description TODO
 */
public class 第K个语法符号 {
    public int kthGrammar(int n, int k) {
        if(n == 1) {
            return 0;
        }

        return (k & 1) ^ 1 ^ kthGrammar(n - 1, (k + 1) / 2);
    }
}
