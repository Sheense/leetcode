package sheen.leetcode.array;

/**
 * @Classname 通过连接另一个数组的子数组得到一个数组
 * @Date 2022/12/17 10:41 上午
 * @Created by sheen
 * @Description TODO
 */
public class 通过连接另一个数组的子数组得到一个数组 {
    public static void main(String[] args) {
        通过连接另一个数组的子数组得到一个数组 s = new 通过连接另一个数组的子数组得到一个数组();
        //System.out.println(s.canChoose(new int[][]{{1,-1,-1},{3,-2,0}}, new int[]{1,-1,0,1,-1,-1,3,-2,0}));
        //System.out.println(s.canChoose(new int[][]{{1,2,3},{3,4}}, new int[]{7,7,1,2,3,4,7,7}));
        System.out.println(s.canChoose(new int[][]{{21,22,21,22,21,30}}, new int[]{21,22,21,22,21,22,21,30}));
    }
    public boolean canChoose(int[][] groups, int[] nums) {
        int index = 0;
        for(int i = 0; i < groups.length; i++) {
            boolean flag = false;
            for (;;) {
                int copy = index;
                int j = 0;
                while (copy < nums.length && j < groups[i].length && nums[copy] == groups[i][j]) {
                    j++;
                    copy++;
                }

                if(j == groups[i].length) {
                    flag = true;
                    index = copy;
                    break;
                }else {
                    index++;
                }

                if(index >= nums.length) {
                    break;
                }
            }
            if(!flag) {
                return false;
            }
        }
        return true;
    }
}
