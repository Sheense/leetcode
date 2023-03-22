package sheen.leetcode.string;

/**
 * @Classname 设计Goal解析器
 * @Date 2022/11/6 12:32 下午
 * @Created by sheen
 * @Description TODO
 */
public class 设计Goal解析器 {
    public String interpret(String command) {
        command = command.replace("(al)", "al");
        return command.replace("()", "o");
    }
}
