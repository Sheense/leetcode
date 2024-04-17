package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname 餐厅过滤器
 * @Date 2023/9/27 00:14
 * @Created by sheen
 * @Description TODO
 */
public class 餐厅过滤器 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < restaurants.length; i++) {
            if((veganFriendly == 0 || (restaurants[i][2] == 1)) && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                list.add(i);
            }
        }

        Collections.sort(list, (x, y) -> {
            if(restaurants[x][1] == restaurants[y][1]) {
                if(restaurants[x][0] <= restaurants[y][0]) {
                    return 1;
                }else {
                    return -1;
                }
            }else if(restaurants[x][1] < restaurants[y][1]){
                return 1;
            }else {
                return -1;
            }
        });

        return list.stream().map(x -> restaurants[x][0]).collect(Collectors.toList());
    }
}
