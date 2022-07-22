package sheen.leetcode.math;

/**
 * @Classname 到达终点
 * @Date 2022/4/9 3:37 下午
 * @Created by sheen
 * @Description TODO
 */
public class 到达终点 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if(ty > tx) {
                ty -= tx;
            }else {
                tx -= ty;
            }
        }

        if(tx == sx && ty == sy) {
            return true;
        }else if(tx == sx) {
            return ty > sy && (ty - sy) % sx == 0;
        }else if(ty == sy) {
            return tx > sx && (tx - sx) % sy == 0;
        }else {
            return false;
        }
    }
}
