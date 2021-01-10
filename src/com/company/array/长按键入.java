package com.company.array;

public class 长按键入 {
    public static void main(String[] args) {
        长按键入 s = new 长按键入();
        System.out.println(s.isLongPressedName("pyplrz", "ppyypllr"));
    }
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        while(i<name.length()||j<typed.length()) {
            if(i<name.length()&&j==typed.length()) return false;
            if(i!=name.length()&&name.charAt(i)==typed.charAt(j)) {
                i++;
                j++;
            }else {
                if(i-1>=0&&name.charAt(i-1)==typed.charAt(j)) j++;
                else return false;
            }
        }
        return true;
    }
}
