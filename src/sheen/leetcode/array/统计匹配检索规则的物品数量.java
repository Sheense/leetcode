package sheen.leetcode.array;

import java.util.List;

public class 统计匹配检索规则的物品数量 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        for(int i=0;i<items.size();i++) {
            switch (ruleKey) {
                case "type": {
                    if(items.get(i).get(0).equals(ruleValue)) {
                        res++;
                    }
                    break;
                }
                case "color": {
                    if(items.get(i).get(1).equals(ruleValue)) {
                        res++;
                    }
                    break;
                }
                case "name": {
                    if(items.get(i).get(2).equals(ruleValue)) {
                        res++;
                    }
                    break;
                }
            }
        }
        return res;
    }
}
