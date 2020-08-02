package com.company.string;

public class 比较版本号 {
    public static void main(String[] args) {
        比较版本号 s = new 比较版本号();
        System.out.println(s.compareVersion("0.0","1.0"));
    }
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while(i<str1.length||j<str2.length) {
            if(i==str1.length) {
                while(j<str2.length) {
                    if(Integer.parseInt(str2[j])>0) {
                        return -1;
                    }
                    j++;
                }
                break;
            }
            if(j==str2.length) {
                while(i<str1.length) {
                    if(Integer.parseInt(str1[i])>0) {
                        return 1;
                    }
                    i++;
                }
                break;
            }
            if(Integer.parseInt(str1[i])<Integer.parseInt(str2[j])) {
                return -1;
            }else if(Integer.parseInt(str1[i])>Integer.parseInt(str2[j])) {
                return 1;
            }
            i++;
            j++;
        }
        return 0;
    }
}
