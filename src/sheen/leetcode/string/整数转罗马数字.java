package sheen.leetcode.string;

public class 整数转罗马数字 {

    public static void main(String[] args) {
        整数转罗马数字 s = new 整数转罗马数字();
        System.out.println(s.intToRoman(3999));
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if(num<=4&&num>=1){
             if(num==4) return "IV";
             for (int i=1;i<=num;i++){
                 sb.append("I");
             }
             return sb.toString();
        }
        if(num<=9&&num>=5){
            if(num==9) return "IX";
            sb.append("V");
            for(int i=6;i<=num;i++) {
                sb.append("I");
            }
            return sb.toString();
        }
        if(num>=10&&num<=49) {
            if(num>=40) sb.append("XL");
            else {
               for(int i=1;i<=num/10;i++){
                   sb.append("X");
               }
            }
            if(num%10!=0)  sb.append(intToRoman(num%10));
            return sb.toString();
        }
        if(num>=50&&num<=99) {
            if(num>=90) {
                sb.append("XC");
            }else {
                sb.append("L");
                for(int i=6;i<=num/10;i++){
                    sb.append("X");
                }
            }
            if(num%10!=0) sb.append(intToRoman(num%10));
            return sb.toString();
        }

        if(num>=100&&num<=499) {
            if(num>=400) sb.append("CD");
            else {
                for(int i=1;i<=num/100;i++) {
                    sb.append("C");
                }
            }
            if(num%100!=0) sb.append(intToRoman(num%100));
            return sb.toString();
        }
        if(num>=500&&num<=999) {
            if(num>=900) {
                sb.append("CM");
            }else {
                sb.append("D");
                for(int i=6;i<=num/100;i++) {
                    sb.append("C");
                }
            }
            if(num%100!=0) sb.append(intToRoman(num%100));
            return sb.toString();
        }

        if(num>=1000&&num<=3999) {
            for(int i=1;i<=num/1000;i++) {
                sb.append("M");
            }
            if(num%1000!=0) sb.append(intToRoman(num%1000));
            return sb.toString();
        }
        return sb.toString();
    }
}
