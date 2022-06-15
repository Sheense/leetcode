package com.company.string;

import com.company.util.ArrayUtils;

/**
 * @Classname 验证IP地址
 * @Date 2022/5/29 12:41 上午
 * @Created by sheen
 * @Description TODO
 */
public class 验证IP地址 {
    public static void main(String[] args) {
        验证IP地址 s = new 验证IP地址();
        System.out.println(s.validIPAddress("20EE:Fb8:85a3:0:0:8A2E:0370:7334"));
    }
    public String validIPAddress(String queryIP) {
        if(queryIP.length() == 0) {
            return "Neither";
        }
        boolean ip6 = queryIP.contains(":");
        if(ip6) {
            if(queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length() - 1) == ':') {
                return "Neither";
            }
            String[] strs = queryIP.split(":");
            if(strs.length != 8) return "Neither";
            for(int i = 0; i < strs.length; i++) {
                if(strs[i].length() > 4 || strs[i].length() == 0) {
                    return "Neither";
                }

                for(int j = 0; j < strs[i].length(); j++) {
                    char c = strs[i].charAt(j);
                    if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')) {
                        continue;
                    }

                    return "Neither";
                }
            }

            return "IPv6";
        }else {
            if(queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length() - 1) == '.') {
                return "Neither";
            }
            String[] strs = queryIP.split("\\.");
            if(strs.length != 4) {
                return "Neither";
            }

            for(int i = 0; i < strs.length; i++) {
                int v;
                try {
                    v = Integer.valueOf(strs[i]);
                    if(v > 255) {
                        return "Neither";
                    }
                }catch (Exception e) {
                    return "Neither";
                }

                if(v == 0 && strs[i].length() > 1) {
                    return "Neither";
                }
                boolean flag = true;
                for(int j = 0; j < strs[i].length(); j++) {
                    if(strs[i].charAt(j) == '0' && flag && v != 0) {
                        return "Neither";
                    }
                    flag = false;
                }
            }
            return "IPv4";
        }
    }
}
