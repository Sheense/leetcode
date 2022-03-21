package com.company.bitOperation;

/**
 * @Classname UTF_8编码验证
 * @Date 2022/3/13 1:00 上午
 * @Created by sheen
 * @Description TODO
 */
public class UTF_8编码验证 {
    public static void main(String[] args) {
        UTF_8编码验证 s = new UTF_8编码验证();
        System.out.println(s.validUtf8(new int[]{250,145,145,145,145}));
    }
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            if(checkItem(data[i])) {
                return false;
            }
            int count = 7;
            while (((1 << count) & data[i]) > 0) {
                System.out.println((1 << count) & data[i]);
                count--;
            }
            if(count < 7) {
                int time = 7 - count - 1;
                if(time >= 4) {
                    return false;
                }
                i++;
                while (i < data.length && time-- > 0) {
                    if(!checkItem(data[i])) {
                        return false;
                    }
                    i++;
                }
                    if(time > 0) {
                        return false;
                    }
            }else {
                i++;
            }

        }
        return true;

    }

    public boolean checkItem(int d) {
        int a = 1 << 7;
        if(a > d) {
            return false;
        }

        a = d - a;
        return  a < (1 << 6);
    }
}
