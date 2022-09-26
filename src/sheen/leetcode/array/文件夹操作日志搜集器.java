package sheen.leetcode.array;

/**
 * @Classname 文件夹操作日志搜集器
 * @Date 2022/9/9 12:18 上午
 * @Created by sheen
 * @Description TODO
 */
public class 文件夹操作日志搜集器 {

    public static void main(String[] args) {
        文件夹操作日志搜集器 s = new 文件夹操作日志搜集器();
        System.out.println(s.minOperations(new String[]{"./","../","./"}));
    }
    public int minOperations(String[] logs) {
        int res = 0;
        for(int i = 0; i < logs.length; i++) {
            if(logs[i].equals("../") && res > 0) {
                res--;
            }else if(!logs[i].equals("./")){
                res++;
            }
        }
        return res;
    }
}
