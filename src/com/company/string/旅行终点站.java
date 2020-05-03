package com.company.string;

import java.util.Arrays;
import java.util.List;

public class 旅行终点站 {


    public static void main(String[] args) {
        旅行终点站 s = new 旅行终点站();
        System.out.println(s.destCity(Arrays.asList(
                            Arrays.asList("London","New York"),
                            Arrays.asList("New York","Lima"),
                            Arrays.asList("Lima","Sao Paulo")
        )));
    }

    public String destCity(List<List<String>> paths) {
        for(int i=0;i<paths.size();i++) {
            String string = paths.get(i).get(1);
            boolean flag = true;
            for(int j=0;j<paths.size();j++) {
                if(j!=i) {
                    if(paths.get(j).get(0).equals(string)){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) return string;
        }
        return "";
    }
}
