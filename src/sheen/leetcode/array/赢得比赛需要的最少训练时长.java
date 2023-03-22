package sheen.leetcode.array;

/**
 * @Classname 赢得比赛需要的最少训练时长
 * @Date 2023/3/13 3:43 上午
 * @Created by sheen
 * @Description TODO
 */
public class 赢得比赛需要的最少训练时长 {
    public static void main(String[] args) {
        赢得比赛需要的最少训练时长 s = new 赢得比赛需要的最少训练时长();
        System.out.println(s.minNumberOfHours(1,1,
                new int[]{1,1,1,1}, new int[]{1,1,1,50}));
    }
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res = 0;
        int start = initialEnergy;
        for(int i = 0; i < energy.length; i++) {
            if(start <= energy[i]) {
                res += (energy[i] - start + 1);
                start += (energy[i] - start + 1);
            }
            start -= energy[i];
        }
        start = initialExperience;
        for(int i = 0; i < experience.length; i++) {
            if(start <= experience[i]) {
                res += (experience[i] - start + 1);
                start += (experience[i] - start + 1);
            }
            start += experience[i];
        }

        return res;
    }
}
