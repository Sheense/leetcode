package com.company.array;

/**
 * @Classname 给植物浇水
 * @Date 2021/11/21 10:49 上午
 * @Created by sheen
 * @Description TODO
 */
public class 给植物浇水 {
    public static void main(String[] args) {
        给植物浇水 s = new 给植物浇水();
        System.out.println(s.wateringPlants(new int[]{2,2,3,4}, 5));
    }
    public int wateringPlants(int[] plants, int capacity) {

        int yu = capacity;
        int res = 0;
        for(int i = 0; i < plants.length; i++) {
            if(plants[i] > yu) {
                res += 2*(i - 1 - (-1));
                yu = capacity;
            }
            yu -= plants[i];
            res ++;
        }

        return res;
    }
}
