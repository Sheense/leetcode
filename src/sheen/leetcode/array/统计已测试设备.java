package sheen.leetcode.array;

/**
 * @Classname 统计已测试设备
 * @Date 2024/5/10 00:04
 * @Created by sheen
 * @Description TODO
 */
public class 统计已测试设备 {
    public static void main(String[] args) {
        统计已测试设备 s = new 统计已测试设备();
        System.out.println(s.countTestedDevices(new int[]{1,1,2,1,3}));
    }
    public int countTestedDevices(int[] batteryPercentages) {
        int res = 0;
        int skip = 0;
        for(int i = 0; i < batteryPercentages.length; i++) {
            int v = batteryPercentages[i] - i + skip;
            if(v > 0) {
                res++;
            }else  {
                skip++;
            }
         }
        return res;
    }
}
