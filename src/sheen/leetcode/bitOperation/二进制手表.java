package sheen.leetcode.bitOperation;

import java.util.ArrayList;
import java.util.List;

public class 二进制手表 {

    public static void main(String[] args) {
        二进制手表 s = new 二进制手表();
        System.out.println(s.readBinaryWatch(1));
    }
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i <= turnedOn && i<= 3; i++) {
            for(int j = 0; j < 12; j++) {
                int count = getCount(j);
                if(count == i) {
                    String item = String.valueOf(j) + ":";
                    int yu = turnedOn - i;
                    for(int z = 0; z < 60; z++) {
                        int c = getCount(z);
                        if(c == yu) {
                            if(z < 10) {
                                res.add(item + "0" + z);
                            }else {
                                res.add(item + z);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public int getCount(int q) {
        int count = 0;
        while (q!=0) {
            if((q & 1) == 1) {
                count ++;
            }
            q>>=1;
        }
        return count;
    }
}
