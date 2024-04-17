package sheen.leetcode.greedyAlgorithm;

import java.util.*;

/**
 * @Classname 可被三整除的最大和
 * @Date 2023/6/19 12:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 可被三整除的最大和 {
    public static void main(String[] args) {
        可被三整除的最大和 s = new 可被三整除的最大和();
        System.out.println(s.maxSumDivThree(new int[]{366,809,6,792,822,181,210,588,344,618,341,410,121,864,191,749,637,169,123,472,358,908,235,914,322,946,738,754,908,272,267,326,587,267,803,281,586,707,94,627,724,469,568,57,103,984,787,552,14,545,866,494,263,157,479,823,835,100,495,773,729,921,348,871,91,386,183,979,716,806,639,290,612,322,289,910,484,300,195,546,499,213,8,623,490,473,603,721,793,418,551,331,598,670,960,483,154,317,834,352}));
    }
    public int maxSumDivThree(int[] nums) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 3 == 1) {
                one.add(nums[i]);
            }else if(nums[i] % 3 == 2){
                two.add(nums[i]);
            }
            res += nums[i];
        }
        int yu1 = one.size() % 3;
        int yu2 = two.size() % 3;
        if(yu1 == yu2) {
            return res;
        }
        Collections.sort(one);
        Collections.sort(two);
        int min = 0;
        if(yu1 == 2 && yu2 == 1) {
            min = one.get(0);
            if(two.size() >= 4) {
                min = Math.min(min, two.get(0) + two.get(1));
            }
        }
        if(yu1 == 1 && yu2 == 2){
            min = two.get(0);
            if(one.size() >= 4) {
                min = Math.min(min, one.get(0) + one.get(1));
            }
        }
        if(yu1 == 0) {
            if(yu2 == 1) {
                min = two.get(0);
                if(one.size() > 0) {
                    min = Math.min(min, one.get(0) + one.get(1));
                }
            }else {
                min = two.get(0) + two.get(1);
                if(one.size() > 0) {
                    min = Math.min(min, one.get(0));
                }
            }
        }

        if(yu2 == 0) {
            if(yu1 == 1) {
                min = one.get(0);
                if(two.size() > 0) {
                    min = Math.min(min, two.get(0) + two.get(1));
                }
            }else {
                min = one.get(0) + one.get(1);
                if(two.size() > 0) {
                    min = Math.min(min, two.get(0));
                }
            }
        }


        return res - min;
    }
}
