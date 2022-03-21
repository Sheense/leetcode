package com.company.string;

/**
 * @Classname 将标题首字母大写
 * @Date 2022/1/8 10:33 下午
 * @Created by sheen
 * @Description TODO
 */
public class 将标题首字母大写 {
    public String capitalizeTitle(String title) {
        title = title.toLowerCase();
        String[] strings = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strings.length; i++) {
            if(strings[i].length() <= 2) {
                sb.append(strings[i]);
            }else {
                int v = strings[i].charAt(0) - 'a';
                sb.append((char)(v + 'A') + strings[i].substring(1));
            }
            if(i != strings.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
