package sheen.leetcode.math;

/**
 * @Classname 路径交叉
 * @Date 2021/10/29 1:24 上午
 * @Created by sheen
 * @Description TODO
 */
public class 路径交叉 {
    public boolean isSelfCrossing(int[] distance) {
        for(int i = 0 ; i < distance.length; i++) {
            if(i - 3 >= 0) {
                if(distance[i - 1] <= distance[i - 3] && distance[i-2] <= distance[i]) {
                    return true;
                }
            }

            if(i == 4) {
                if(distance[i - 1] == distance[i - 3] &&  distance[i] + distance[i - 4] >= distance[i - 2]) {
                    return true;
                }
            }

            if(i - 5 >= 0) {
                if(distance[i-3] > distance[i-1] && distance[i - 1] + distance[i-5] >= distance[i-3]
                   &&distance[i-2] > distance[i-4] && distance[i] + distance[i-4] >= distance[i-2]){
                    return true;
                }
            }

        }
        return false;
    }
}
