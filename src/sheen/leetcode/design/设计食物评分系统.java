package sheen.leetcode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Classname 设计食物评分系统
 * @Date 2022/7/24 10:42 上午
 * @Created by sheen
 * @Description TODO
 */
public class 设计食物评分系统 {

    public static void main(String[] args) {
            System.out.println("ramen".compareTo("sushi"));
        FoodRatings s = new FoodRatings(
                new String[]{"cpctxzh","bryvgjqmj","wedqhqrmyc","ee","lafzximxh","lojzxfel","flhs"},
                new String[]{"wbhdgqphq","wbhdgqphq","mxxajogm","wbhdgqphq","wbhdgqphq","mxxajogm","mxxajogm"},
                new int[]{15,5,7,16,16,10,13}
        );
        s.changeRating("lojzxfel", 1);
        System.out.println(s.highestRated("mxxajogm"));
        System.out.println(s.highestRated("wbhdgqphq"));
        System.out.println(s.highestRated("mxxajogm"));
    }
    static class FoodRatings {

        private int[] ratings;
        private String[] cuisines;
        Map<String, TreeMap<String, Integer>> cuisinesMap = new HashMap<>();
        Map<String, Integer> foodMap = new HashMap<>();
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            this.cuisines = cuisines;
            for(int i = 0; i < foods.length; i++) {
                foodMap.put(foods[i], i);
            }
            this.ratings = ratings;
            for(int i = 0; i < cuisines.length; i++) {
                cuisinesMap.computeIfAbsent(cuisines[i], z ->  new TreeMap<>((x, y) -> {
                    if(ratings[foodMap.get(x)] == ratings[foodMap.get(y)]) {
                        return x.compareTo(y);
                    }
                    return ratings[foodMap.get(y)] - ratings[foodMap.get(x)] > 0 ? 1 : -1;
                })).put(foods[i], i);
            }
        }

        public void changeRating(String food, int newRating) {
            int index = foodMap.get(food);
            TreeMap<String, Integer> map = cuisinesMap.get(cuisines[index]);
            map.remove(food);
            ratings[index] = newRating;
            map.put(food, index);
        }

        public String highestRated(String cuisine) {
            return cuisinesMap.get(cuisine).firstKey();
        }
    }
}
