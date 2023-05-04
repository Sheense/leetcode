package sheen.leetcode.string;

/**
 * @Classname 统计共同度过的日子数
 * @Date 2023/4/17 3:13 下午
 * @Created by sheen
 * @Description TODO
 */
public class 统计共同度过的日子数 {
    public static void main(String[] args) {
        统计共同度过的日子数 s = new 统计共同度过的日子数();
        System.out.println(s.countDaysTogether("09-01", "10-19", "06-19", "10-20"));
    }
    private int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String[] p1;
        String[] p2;
        if(!isBig(arriveAlice, arriveBob)) {
            p1 = new String[]{arriveAlice, leaveAlice};
            p2 = new String[]{arriveBob, leaveBob};
        }else {
            p2 = new String[]{arriveAlice, leaveAlice};
            p1 = new String[]{arriveBob, leaveBob};
        }

        if(!isBig(p1[1], p2[0])) {
            return p1[1].equals(p2[0]) ? 1 : 0;
        }

        String end = isBig(p1[1], p2[1]) ? p2[1] : p1[1];
        String start = isBig(p1[0], p2[0]) ? p1[0] : p2[0];
        String arr1[] = start.split("-");
        String arr2[] = end.split("-");
        int month1 = Integer.parseInt(arr1[0]);
        int day1 = Integer.parseInt(arr1[1]);
        int month2 = Integer.parseInt(arr2[0]);
        int day2 = Integer.parseInt(arr2[1]);
        if(month1 == month2) {
            return day2 - day1 + 1;
        }

        int res = 0;
        for(int i = month1; i <= month2; i++) {
            if(i == month1) {
                res += days[i - 1] - day1 + 1;
            }else if(i == month2) {
                res += day2;
            }else {
                res += days[i - 1];
            }
        }
        return res;
    }

    public boolean isBig(String date1, String date2) {
        if(date1.equals(date2)) {
            return true;
        }

        String[] arr1 = date1.split("-");
        String[] arr2 = date2.split("-");
        int month1 = Integer.parseInt(arr1[0]);
        int day1 = Integer.parseInt(arr1[1]);
        int month2 = Integer.parseInt(arr2[0]);
        int day2 = Integer.parseInt(arr2[1]);
        if(month2 < month1) {
            return true;
        }else if(month2 > month1) {
            return false;
        }else {
            if(day1 > day2) {
                return true;
            }else {
                return false;
            }
        }
    }
}
