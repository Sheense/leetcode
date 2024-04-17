package sheen.leetcode.array;

/**
 * @Classname 分糖果II
 * @Date 2023/5/5 11:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class 分糖果II {
    public int[] distributeCandies(int candies, int num_people) {
        int [] ans = new int[num_people];
        int now = 1;
        int i = 0;
        while (candies != 0) {
            if(candies >= now) {
                ans[i % num_people] += now;
                candies -= now;
            }else {
                ans[i % num_people] += candies;
                candies = 0;
            }
            i ++;
            i %= num_people;
            now++;
        }
        return ans;
    }
}
