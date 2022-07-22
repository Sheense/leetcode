package sheen.leetcode.array;

public class 缀点成线 {
    public static void main(String[] args) {
        缀点成线 s = new 缀点成线();
        System.out.println(s.checkStraightLine(new int[][]{{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}}));
    }
    public boolean checkStraightLine(int[][] coordinates) {
        boolean flag = false;
        String q = "";
        if(coordinates[0][0]-coordinates[1][0]!=0) {
            double value = (double)(coordinates[0][1]-coordinates[1][1])/(coordinates[0][0]-coordinates[1][0]);
            if(value==-0.0) value = 0.0;
            q = String.valueOf(value);
        }else {
            flag = true;
        }
        for(int i=0;i<coordinates.length-1;i++) {
            for(int j=i+1;j<coordinates.length;j++) {
                if(flag) {
                    if(coordinates[i][0]-coordinates[j][0]!=0) {
                        return false;
                    }
                    continue;
                }
                double newValue = (double)(coordinates[i][1]-coordinates[j][1])/(coordinates[i][0]-coordinates[j][0]);
                if(newValue==-0.0) {
                    newValue = 0;
                }
                String newQ = String.valueOf(newValue);
                if(newQ.compareTo(q)!=0) {
                    return false;
                }
            }
        }
        return true;
    }
}
