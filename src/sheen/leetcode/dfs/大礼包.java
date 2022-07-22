package sheen.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 大礼包
 * @Date 2021/10/24 2:17 下午
 * @Created by sheen
 * @Description TODO
 */
public class 大礼包 {
    public static void main(String[] args) {
        大礼包 s = new 大礼包();
        System.out.println(s.shoppingOffers(Arrays.asList(2,3,4), Arrays.asList(Arrays.asList(1,1,0,4), Arrays.asList(2,2,1,9)), Arrays.asList(1, 2, 1)));
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        List<List<Integer>> realSpecial = new ArrayList<>();
        for(List<Integer> item : special) {
            int all = 0;
            boolean flag = true;
            for(int j = 0; j < item.size() - 1; j++) {
                all += item.get(j) * price.get(j);
                if(item.get(j) > needs.get(j)) {
                    flag = false;
                    break;
                }
            }
            if(all > item.get(item.size() - 1) && flag) {
                realSpecial.add(item);
            }
        }

        return recall(needs, price, realSpecial);
    }

    public int recall(List<Integer> needs, List<Integer> prices, List<List<Integer>> realSpecial) {
        if(check(needs)) {
            return 0;
        }
        int min = 0;
        for(int i = 0; i < needs.size(); i++) {
            min += prices.get(i) * needs.get(i);
        }

        for(int i = 0; i < realSpecial.size(); i++) {
            if(check(needs, realSpecial.get(i)) && realSpecial.get(i).get(needs.size()) < min) {
                List<Integer> newNeed = new ArrayList<>();
                for(int j = 0; j < needs.size(); j++) {
                    newNeed.add(needs.get(j) - realSpecial.get(i).get(j));
                }
                int r = recall(newNeed, prices, realSpecial);
                if(r + realSpecial.get(i).get(needs.size()) < min) {
                    min = r + realSpecial.get(i).get(needs.size());
                }
            }
        }

        return min;
    }
    public boolean check(List<Integer> a) {
        for(int i : a){
            if(i > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean check(List<Integer> a, List<Integer> b) {
        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) < b.get(i)) {
                return false;
            }
        }
        return true;
    }
}
