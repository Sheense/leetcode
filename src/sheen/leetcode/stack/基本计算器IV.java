package sheen.leetcode.stack;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

/**
 * @Classname 基本计算器IV
 * @Date 2023/3/10 5:25 下午
 * @Created by sheen
 * @Description TODO
 */
public class 基本计算器IV {

    public static void main(String[] args) {
        基本计算器IV s = new 基本计算器IV();
        //"-1 * a * b + a - 2 * b * (1 + bb) - aa - 10"
        System.out.println("a*b".compareTo("a*bk"));
        List<String> list = new ArrayList<>(Arrays.asList("bk*cc","a*bk","b*cc","a*b","ar","bk","cc","a","b",""));
        System.out.println(list);
        System.out.println(s.basicCalculatorIV("a * b + a - 2 * b * (1 + bb) - aa - 10", new String[]{}, new int[]{}));
    }
    private static Set<Character> set = new HashSet<>(Arrays.asList('(', ')', '+', '-', '*'));
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {

        expression = expression.replace(" ", "");
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < evalints.length; i++) {
            map.put(evalvars[i], evalints[i]);
        }
        Stack<Character> fu = new Stack<>();
        // 常数{"8", ""}，只有字母，{"1", "abc"}
        Stack<List<String[]>> value = new Stack<>();

        int i = 0;
        while (i < expression.length()) {
            if(expression.charAt(i) == '(') {
                fu.push(expression.charAt(i));
                i++;
            }else if(expression.charAt(i) == '*') { //后一个不为(触发
                if(expression.charAt(i + 1) == '(') {
                    fu.push('*');
                    i++;
                }else {
                    int end = getValueEnd(expression, i + 1);
                    String v = expression.substring(i + 1, end);
                    List<String[]> newItems = new ArrayList<>();
                    List<String[]> pre = value.pop();
                    for(String[] item : pre) {
                        if(map.containsKey(v)) {
                            item[0] = String.valueOf(Integer.parseInt(item[0]) * map.get(v));
                        }else {
                            if(isNum(v)) {
                                item[0] = String.valueOf(Integer.parseInt(item[0]) * Integer.parseInt(v));
                            }else {
                                if(item[1].equals("")) {
                                    item[1] = v;
                                }else {
                                    item[1] += "*" + v;
                                }
                            }
                        }
                        newItems.add(item);
                    }
                    value.push(newItems);
                    i = end;
                }
            }else if(expression.charAt(i) == ')') {//处理到（并且，如果（前一个为*，一起处理
                List<String[]> newItems = new ArrayList<>();
                while (!fu.isEmpty() && fu.peek() != '(') {
                    fu.pop();
                    newItems.addAll(value.pop());
                }
                fu.pop();
                newItems.addAll(value.pop());

                //处理（前一个为*的情况,
                if (!fu.isEmpty() && fu.peek() == '*') {
                    fu.pop();
                    List<String[]> pre = value.pop();
                    List<String[]> last = newItems;
                    newItems = new ArrayList<>();
                    for(String[] preItem : pre) {
                        for(String[] lastItem : last) {
                            String a = String.valueOf(Integer.parseInt(preItem[0]) * Integer.parseInt(lastItem[0]));
                            String b = preItem[1].equals("") || lastItem[1].equals("") ? (preItem[1].equals("") ? lastItem[1] : preItem[1]) : (preItem[1] + "*" + lastItem[1]);
                            newItems.add(new String[]{a, b});
                        }
                    }
                }

                value.push(newItems);
                i++;
            }else if(expression.charAt(i) == '-'){
                //-()= -1 * () 浊者 ()-()=() + -1 * ()
                if(expression.charAt(i + 1) == '(') {
                    if(i - 1 >= 0) {
                        fu.push('+');
                    }
                    List<String[]> item = new ArrayList<>();
                    item.add(new String[] {"-1", ""});
                    value.push(item);
                    fu.push('*');
                    i++;
                }else { // -1 * a * b 或者 a -1 * a * b = a + -1 * a * b
                    int end = getValueEnd(expression, i + 1);
                    String v = expression.substring(i + 1, end);
                    List<String[]> item = getItem(v, map);
                    item.get(0)[0] = String.valueOf(Integer.parseInt(item.get(0)[0]) * -1);
                    value.push(item);
                    if(i - 1 >= 0) {
                        fu.push('+');
                    }
                    i = end;
                }
            }else if(expression.charAt(i) == '+') {
                fu.push('+');
                if(expression.charAt(i + 1) == '(') {
                    i++;
                }else {
                    int end = getValueEnd(expression, i + 1);
                    String v = expression.substring(i + 1, end);
                    List<String[]> item = getItem(v, map);
                    value.push(item);
                    i = end;
                }
            }else {
                int end = getValueEnd(expression, i);
                String v = expression.substring(i, end);
                List<String[]> item = getItem(v, map);
                value.push(item);

                i = end;
            }
        }
        List<String[]> res = new ArrayList<>();
        while (!value.isEmpty()) {
            res.addAll(value.pop());
        }
        TreeMap<String, Integer> resMap = new TreeMap<>((a, b) -> {
            int len1 = a.equals("") ? 0 : a.split("\\*").length;
            int len2 = b.equals("") ? 0 : b.split("\\*").length;
            if(len1 != len2) {
                return len2 - len1;
            }

            return a.compareTo(b);
        });
        for(String[] item : res) {
            String key = item[1];
            int count = Integer.parseInt(item[0]);
            String[] values = key.split("\\*");
            Arrays.sort(values);
            key = String.join("*", values);
            resMap.put(key, resMap.getOrDefault(key, 0) + count);
        }

        List<String> ans = new ArrayList<>();
        for(Map.Entry<String, Integer> item : resMap.entrySet()) {
            int count = item.getValue();
            String key = item.getKey();
            if(count != 0) {
                if(key.equals("")) {
                    ans.add(count + key);
                }else {
                    ans.add(count + "*" + key);
                }
            }
        }
        return ans;
    }

    public List<String[]> getItem(String v, Map<String, Integer> map) {
        List<String[]> item = new ArrayList<>();
        if(map.containsKey(v)) {
            item.add(new String[]{String.valueOf(map.get(v)), ""});
        }else {
            if(isNum(v)) {
                item.add(new String[]{v, ""});
            }else {
                item.add(new String[]{"1", v});
            }
        }
        return item;
    }

    public boolean isNum(String v) {
        try {
            Integer.parseInt(v);
        }catch (Exception e) {
            return false;
        }

        return true;
    }

    public int getValueEnd(String expression, int start) {
        int end = start;
        while (end < expression.length() && !set.contains(expression.charAt(end))) {
            end++;
        }
        return end;
    }
}
