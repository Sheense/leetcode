package sheen.leetcode.array;

/**
 * @Classname 统计道路上的碰撞次数
 * @Date 2022/3/20 5:25 下午
 * @Created by sheen
 * @Description TODO
 */
public class 统计道路上的碰撞次数 {
    public static void main(String[] args) {
        统计道路上的碰撞次数 s = new 统计道路上的碰撞次数();
        System.out.println(s.countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }
    public int countCollisions(String directions) {
        int res = 0;
        char[] cs = directions.toCharArray();
        int i = 0;
        while (i < directions.length()) {
            if(cs[i] == 'R') {
                int index =i + 1;
                while (index < directions.length() && cs[index] == 'R') {
                    index++;
                }
                if(index == directions.length()) {
                    break;
                }
                if(cs[index] == 'S') {
                    res += index - i;
                }
                if(cs[index] == 'L') {
                    res += index - i + 1;
                    cs[index] = 'S';
                }
                i = index + 1;
            }else {
                i++;
            }
        }
        i = cs.length - 1;
        while (i >= 0) {
            if(cs[i] == 'L') {
                int index = i - 1;
                while (index >= 0 && cs[index] == 'L') {
                    index--;
                }
                if(index < 0) {
                    break;
                }

                res += i - index;
                i = index - 1;
            }else {
                i--;
            }
        }
        return res;
    }
}
