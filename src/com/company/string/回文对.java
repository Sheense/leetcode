package com.company.string;

import java.util.*;

public class 回文对 {
    public static void main(String[] args) {
        回文对 s = new 回文对();
        System.out.println(s.palindromePairs(new String[]{"a","abc","aba",""}));
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, String> reserveMap = new HashMap<>();
        Map<Integer, Map<Integer, Boolean>> preMap = new HashMap<>();
        Map<Integer, Map<Integer, Boolean>> lastMap = new HashMap<>();
        for(int i=0;i<words.length;i++) {
            reserveMap.put(i, reserve(words[i]));
            if(words[i].length()==0) continue;
            Map<Integer, Boolean> pMap = new HashMap<>();
            Map<Integer, Boolean> lMap = new HashMap<>();
            for(int j=1;j<=words[i].length();j++) {
                pMap.put(j,check(words[i].substring(0,j)));
                if(j!=words[i].length()) {
                    lMap.put(j, check(words[i].substring(j)));
                }
            }
            preMap.put(i, pMap);
            lastMap.put(i, lMap);
        }
        for(int i=0;i<words.length-1;i++) {
            for(int j=i+1;j<words.length;j++) {
                if(words[i].length()==words[j].length()) {
                    if(reserveMap.get(j).equals(words[i])) {
                        res.add(Arrays.asList(i,j));
                        res.add(Arrays.asList(j,i));
                    }
                }else if(words[i].length()<words[j].length()) {
                    if(words[i].length()==0) {
                        if(preMap.get(j).get(words[j].length())){
                            res.add(Arrays.asList(i,j));
                            res.add(Arrays.asList(j,i));
                        }
                    }else {
                        String reserveString = reserveMap.get(i);
                        String pre1 = words[j].substring(0,words[i].length());
                        String last2 = words[j].substring(words[j].length()-words[i].length());
                        if(reserveString.equals(pre1)&&lastMap.get(j).get(words[i].length())) {
                            res.add(Arrays.asList(j,i));
                        }
                        if(reserveString.equals(last2)&&preMap.get(j).get(words[j].length()-words[i].length())) {
                            res.add(Arrays.asList(i,j));
                        }
                    }
                } else {
                    if(words[j].length()==0) {
                        if(preMap.get(i).get(words[i].length())){
                            res.add(Arrays.asList(i,j));
                            res.add(Arrays.asList(j,i));
                        }
                    }else {
                        String reserveString = reserveMap.get(j);
                        String pre1 = words[i].substring(0,words[j].length());
                        String last2 = words[i].substring(words[i].length()-words[j].length());
                        if(reserveString.equals(pre1)&&lastMap.get(i).get(words[j].length())) {
                            res.add(Arrays.asList(i,j));
                        }
                        if(reserveString.equals(last2)&&preMap.get(i).get(words[i].length()-words[j].length())) {
                            res.add(Arrays.asList(j,i));
                        }
                    }
                }
            }
        }
        return res;
    }
    public boolean check(String value) {
        for(int i=0;i<value.length()/2;i++) {
            if(value.charAt(i)!=value.charAt(value.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    public String reserve(String value) {
        return new StringBuffer(value).reverse().toString();
    }
}
