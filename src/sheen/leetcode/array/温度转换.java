package sheen.leetcode.array;

/**
 * @Classname 温度转换
 * @Date 2023/3/21 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 温度转换 {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.8 + 32};
    }
}
