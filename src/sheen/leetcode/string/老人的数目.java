package sheen.leetcode.string;

/**
 * @Classname 老人的数目
 * @Date 2023/10/23 00:13
 * @Created by sheen
 * @Description TODO
 */
public class 老人的数目 {
    public int countSeniors(String[] details) {
        int res = 0;
        for(String item : details) {
            int ago = Integer.parseInt(item.substring(11, 13));
            if(ago > 60) {
                res ++;
            }
        }
        return res;
    }
}
