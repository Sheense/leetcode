package array;

import java.util.ArrayList;
import java.util.List;

public class 拥有最多糖果的孩子 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int i=0;i<candies.length;i++) {
            if(candies[i]>max) max = candies[i];
        }
        List<Boolean> booleans = new ArrayList<>();
        for(int i=0;i<candies.length;i++) {
            if(candies[i]+extraCandies>=max) booleans.add(true);
            else booleans.add(false);
        }
        return booleans;
    }
}
