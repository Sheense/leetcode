package sheen.leetcode.hash;

public class Excel表列名称 {
    public static void main(String[] args) {
        Excel表列名称 s= new Excel表列名称();
        System.out.println(s.convertToTitle(52));
    }
    public String convertToTitle(int columnNumber) {
        String res = "";
        while (columnNumber > 26) {
            int a = columnNumber / 26;
            int yu = columnNumber % 26;
            char c = yu == 0 ? 'Z' : (char)(yu -1 + 'A');
            if(yu == 0) {
                a--;
            }
            res =  c + res;
            columnNumber = a;
        }
        if(columnNumber != 0) res = (char)(columnNumber -1 + 'A') + res;
        return res;
    }
}
