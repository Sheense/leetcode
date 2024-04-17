package sheen.leetcode.easy;

/**
 * @Classname 根据规则将箱子分类
 * @Date 2023/10/20 00:12
 * @Created by sheen
 * @Description TODO
 */
public class 根据规则将箱子分类 {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = false;
        boolean isHeavy = false;
        if(length >= 10000 || width >= 10000 || height >= 10000 || length * width * height >= Math.pow(10, 9)) {
            isBulky = true;
        }

        if(mass >= 100) {
            isHeavy = true;
        }

        if(isBulky && isHeavy) {
            return "Both";
        }

        if(!isBulky && !isHeavy) {
            return "Neither";
        }
        if(isBulky) {
            return "Bulky";
        }
        return "Heavy";
    }
}
