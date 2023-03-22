package sheen.leetcode.array;

/**
 * @Classname 执行操作后的变量值
 * @Date 2022/12/23 12:04 上午
 * @Created by sheen
 * @Description TODO
 */
public class 执行操作后的变量值 {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for(int i = 0; i < operations.length; i++)  {
            if(operations[i].contains("-")) {
                res--;
            }else if(operations[i].contains("+")) {
                res++;
            }
        }
        return res;
    }
}
