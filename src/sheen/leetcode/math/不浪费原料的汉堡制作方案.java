package sheen.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 不浪费原料的汉堡制作方案
 * @Date 2023/12/25 10:33
 * @Created by sheen
 * @Description TODO
 */
public class 不浪费原料的汉堡制作方案 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if(cheeseSlices > tomatoSlices) {
            return new ArrayList<>();
        }
        int yu = tomatoSlices - 2 * cheeseSlices;
        if(yu < 0) {
            return new ArrayList<>();
        }
        if(yu % 2 == 1) {
            return new ArrayList<>();
        }

        int count = yu / 2;
        if(count > cheeseSlices) {
            return new ArrayList<>();
        }

        return Arrays.asList(count, cheeseSlices - count);
    }
}
