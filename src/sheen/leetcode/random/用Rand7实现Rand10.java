package sheen.leetcode.random;

/**
 * @Classname 用Rand7实现Rand10
 * @Date 2021/9/5 1:47 上午
 * @Created by sheen
 * @Description TODO
 */
public class 用Rand7实现Rand10 {
    /**
     * 解法
     * 1、7*7总共有49个数
     * 打表
     *  1 2 3 4 5 6 7
     *1 1 2 3 4 5 6 7
     *2 8 9 A 1 2 3 4
     *3 5 6 7 8 9 A 1
     *4 2 3 4 5 6 7 8
     *5 9 A 1 2 3 4 5
     *6 6 7 8 9 A * *
     *7 * * * * * * *
     *
     * 2、通过随机行列，如果发现编号是小于等于40的，就接受
     * 通过取余数算出对应的数字
     * @param args
     */
    public static void main(String[] args) {
        用Rand7实现Rand10 s = new 用Rand7实现Rand10();
        System.out.println(s.rand10());
    }
    public int rand10() {
        int num;
        do{
            int row = rand7();
            int column = rand7();
            num = (row - 1) * 7 + column;
        }while (num > 40);
        return 1 + (num - 1) % 10;
    }

    public int rand7(){
        return 0;
    }
}
