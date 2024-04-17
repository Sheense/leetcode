package sheen.leetcode.string;

/**
 * @Classname 判断两个事件是否存在冲突
 * @Date 2023/5/17 12:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 判断两个事件是否存在冲突 {
    public boolean haveConflict(String[] event1, String[] event2) {
        int star1 = getMinute(event1[0]);
        int end1 = getMinute(event1[0]);
        int start2 = getMinute(event1[0]);
        int end2 = getMinute(event1[0]);
        if(end1 < start2 || end2 < star1) {
            return false;
        }
        return true;
    }

    public int getMinute(String str) {
        String[] items = str.split(":");
        return Integer.parseInt(items[0]) * 60 + Integer.parseInt(items[1]);
    }
}
