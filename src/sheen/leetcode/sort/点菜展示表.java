package sheen.leetcode.sort;

import java.util.*;

public class 点菜展示表 {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(
          Arrays.asList("David","3","Ceviche"),
          Arrays.asList("Corina","10","Beef Burrito"),
          Arrays.asList("David","3","Fried Chicken"),
          Arrays.asList("Carla","5","Water"),
          Arrays.asList("Carla","5","Ceviche"),
          Arrays.asList("Rous","3","Ceviche")
        );
        点菜展示表 s = new 点菜展示表();
        System.out.println(s.displayTable(list));

    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> set = new HashSet<>();
        Map<String, Map<String,Integer>> map = new HashMap<>();
        for (int i=0;i<orders.size();i++) {
            List<String> list = orders.get(i);
            String tableNum = list.get(1);
            String food = list.get(2);
            set.add(food);
            if(!map.containsKey(tableNum)) {
                Map<String,Integer> foods = new HashMap<>();
                map.put(tableNum, foods);
            }
            Map<String,Integer> foods = map.get(tableNum);
            if(foods.containsKey(food)) {
                foods.put(food, foods.get(food) +1);
            }else {
                foods.put(food, 1);
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> head = new ArrayList<>();
        head.addAll(set);
        Collections.sort(head);
        head.add(0,"Table");
        res.add(head);
        for(String table:map.keySet()){
            Map<String,Integer> food = map.get(table);
            List<String> row = new ArrayList<>();
            row.add(table);
            for(int i=1;i<head.size();i++){
                int num = food.containsKey(head.get(i))?food.get(head.get(i)):0;
                row.add(String.valueOf(num));
            }
            res.add(row);
        }
        for(int i=1;i<res.size();i++){
            for(int j=i+1;j<res.size();j++){
                if(Integer.parseInt(res.get(i).get(0))>Integer.parseInt(res.get(j).get(0))){
                    List<String> item = res.get(i);
                    res.set(i,res.get(j));
                    res.set(j, item);
                }
            }
        }

        return res;
    }
}

