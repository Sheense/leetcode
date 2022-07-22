package sheen.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class 整数的英语表示 {
    public static void main(String[] args) {
        整数的英语表示 s = new 整数的英语表示();
        System.out.println(s.numberToWords(10001));
    }

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int q = 1;
        List<String>  res = new ArrayList<>();
        while (num != 0) {
            String now = "";
            switch (q) {
                case 1 : now = "";break;
                case 2 : now = "Thousand";break;
                case 3 : now = "Million";break;
                case 4 : now = "Billion";break;
            }
            int value = 0;
            for(int j = 1;j<=100&&num!=0;j*=10) {
                value += (num%10)*j;
                num/=10;
            }
            if(value > 0) {
                String item = transferString(value);
                if(q == 1) {
                    res.add(item);
                }else {
                    res.add(item + " " + now);
                }
            }
            q++;
        }
        String ans = "";
        for(int i=0;i<res.size();i++) {
            ans = res.get(i)+  (i==0?"":" ") + ans;
        }
        return ans;
    }

    private String[] onePlace = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private String[] twoPlace1 = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] twoPlace2 = new String[]{"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty", "Ninety"};
    public String transferString(int value) {
        List<String> res = new ArrayList<>();
        if(value>=100) {
            res.add(onePlace[value/100-1]);
            res.add("Hundred");
            value %= 100;
        }
        if(value >= 10 && value <= 19) {
            res.add(twoPlace1[value-10]);
            value = 0;
        }
        if(value > 19) {
            res.add(twoPlace2[value/10-2]);
            value %= 10;
        }
        if(value > 0){
            res.add(onePlace[value-1]);
        }
        String ans = "";
        for(int i=0;i<res.size();i++) {
            ans += res.get(i);
            if(i!=res.size()-1) {
                ans += " ";
            }
        }
        return ans;
    }
}
