package com.company.math;

/**
 * @Classname 一周中的第几天
 * @Date 2022/1/3 12:56 上午
 * @Created by sheen
 * @Description TODO
 */
public class 一周中的第几天 {
    public static void main(String[] args) {
        一周中的第几天 s = new 一周中的第几天();
        System.out.println(s.dayOfTheWeek(31, 8, 2019));
    }
    public String dayOfTheWeek(int day, int month, int year) {
        int count = 0;
        for(int i = 1971; i <= year; i++) {
            if(i == year) {
                for(int j = 1; j <= month; j++) {
                    if(j == month) {
                        count+= day;
                        continue;
                    }
                    if(j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j == 10 || j == 12) {
                        count += 31;
                    }else if(j == 2) {
                        if(i % 4 == 0 && i % 100 != 0) {
                            count += 29;
                        }else {
                            count += 28;
                        }
                    }else {
                        count += 30;
                    }
                }
            }else {
                if(i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    count += 366;
                }else {
                    count += 365;
                }
            }
        }
        count+=4;
        count %= 7;
        switch (count) {
            case 1 : return "Monday";
            case 2 : return "Tuesday";
            case 3 : return "Wednesday";
            case 4 : return "Thursday";
            case 5 : return "Friday";
            case 6 : return "Saturday";
            case 0 : return "Sunday";
        }
        return "";
    }
}
