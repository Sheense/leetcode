package sheen.leetcode.math;

public class 矩形重叠 {
    public static void main(String[] args) {
        矩形重叠 s = new 矩形重叠();
        System.out.println(s.isRectangleOverlap(new int[]{-257926405,-680763313,702840196,454409669}, new int[]{-275916328,-417802221,22808107,675629469}));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        long x_length = Math.abs((long) rec2[2]-rec2[0]) + Math.abs((long)rec1[2]-rec1[0]);
        long y_length = Math.abs((long) rec2[3]-rec2[1]) + Math.abs((long)rec1[3]-rec1[1]);
        int max_x = Math.max(Math.max(rec1[0],rec1[2]), Math.max(rec2[0], rec2[2]));
        int min_x = Math.min(Math.min(rec1[0],rec1[2]), Math.min(rec2[0], rec2[2]));

        int max_y = Math.max(Math.max(rec1[1],rec1[3]), Math.max(rec2[1], rec2[3]));
        int min_y = Math.min(Math.min(rec1[1],rec1[3]), Math.min(rec2[1], rec2[3]));

        if(x_length>(max_x-min_x)&&y_length>(max_y-min_y)) return true;
        else return false;
    }
}
