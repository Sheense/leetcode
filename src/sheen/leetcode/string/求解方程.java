package sheen.leetcode.string;

/**
 * @Classname 求解方程
 * @Date 2022/8/10 12:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 求解方程 {
    public static void main(String[] args) {
        求解方程 s = new 求解方程();
        System.out.println(s.solveEquation("2x=x"));
    }
    public String solveEquation(String equation) {
        int[] left = process(equation, 0);
        int[] right = process(equation, equation.indexOf('=') + 1);
        int allLeft = left[0] - right[0];
        int allRight = right[1] - left[1];
        if(allLeft == 0 && allRight == 0) {
            return "Infinite solutions";
        }

        if(allLeft == 0 && allRight != 0) {
            return "No solution";
        }

        return "x=" + (allRight / allLeft);
    }

    public int[] process(String equation, int i) {
        int x = 0;
        int num = 0;
        while (i < equation.length() && equation.charAt(i) != '=') {
            char c = '+';
            if(equation.charAt(i) == '-' || equation.charAt(i) == '+') {
                c =  equation.charAt(i);
                i++;
            }

            int index = i;
            while (i < equation.length() && equation.charAt(i) != '=' && equation.charAt(i) != '+' && equation.charAt(i) != '-') {
                i ++;
            }
            String item = equation.substring(index, i);
            if(item.contains("x")) {
                if(item.length() == 1) {
                    x += Integer.parseInt(c + "1");
                }else {
                    x += Integer.parseInt(c + item.substring(0, item.length() - 1));
                }
            }else {
                num += Integer.parseInt(c + item);
            }
        }

        return new int[]{x, num};
    }
}
