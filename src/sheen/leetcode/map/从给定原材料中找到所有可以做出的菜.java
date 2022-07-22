package sheen.leetcode.map;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname 从给定原材料中找到所有可以做出的菜
 * @Date 2021/12/25 10:36 下午
 * @Created by sheen
 * @Description TODO
 */
public class 从给定原材料中找到所有可以做出的菜 {


    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> success = new HashSet<>();
        Set<String> hasSupplies = new HashSet<>();
        Set<String> recipesSet = new HashSet<>();
        Map<String, List<String>> ingredientsMap = new HashMap<>();
        for(int i = 0; i < recipes.length; i++) {
            recipesSet.add(recipes[i]);
            ingredientsMap.put(recipes[i], ingredients.get(i));
        }
        for(int i = 0; i < supplies.length; i++) {
            hasSupplies.add(supplies[i]);
        }

        for(int i = 0; i < recipes.length; i++) {
            if(success.contains(recipes[i])) continue;
            Set<String> path = new HashSet<>();
            path.add(recipes[i]);
            boolean res = check(ingredientsMap.get(recipes[i]), hasSupplies, success, ingredientsMap, path);
            if(res) {
                success.add(recipes[i]);
            }
        }
        return new ArrayList<>(success);
    }

    public boolean check(List<String> list, Set<String> hasSupplies, Set<String> success, Map<String, List<String>> map, Set<String> path) {
        for(String str : list) {
            if(hasSupplies.contains(str)) continue;
            if(success.contains(str)) continue;
            if(map.containsKey(str) && !path.contains(str)) {
                path.add(str);
                boolean res = check(map.get(str), hasSupplies, success, map, path);
                path.remove(str);
                if(res) {
                    success.add(str);
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
