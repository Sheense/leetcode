package com.company.dfs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class _24点游戏 {
    public static void main(String[] args) {
        _24点游戏 s = new _24点游戏();
        System.out.println(s.judgePoint24(new int[]{8,1,6,6}));
    }


    public boolean judgePoint24(int[] nums) {
        return check(nums, new HashSet<>(), new Stack<>(), new Stack<>());
    }
    public boolean check(int [] nums, Set<Integer> select, Stack<String> num, Stack<Character> fu) {
        if(select.size() == 4) {
            if(fu.isEmpty()) {
                return judge(num.pop());
            }else {
                String value = num.pop();
                while(!fu.isEmpty()) {
                    String new_value = num.pop();
                    char f = fu.pop();
                    value = process(new_value, value, f);
                }
                return judge(value);
            }
        }
        for(int i=0;i<nums.length;i++) {
            if(!select.contains(i)) {
                select.add(i);
                if (select.size()==1) {
                    Stack<String> new_num = new Stack<>();
                    new_num.addAll(num);
                    new_num.push(String.valueOf(nums[i]));
                    Stack<Character> new_fu = new Stack<>();
                    new_fu.addAll(fu);
                    if(check(nums, select, new_num, fu)) {
                        return true;
                    }
                } else { ;
                    for(int j=0;j<4;j++) {
                        switch (j){
                            case 0: {
                                if(judge(num, fu, '+', i,  nums,    select)) {
                                    return true;
                                }
                                break;
                            }
                            case 1: {
                                if(judge(num, fu, '-', i,  nums,   select)) {
                                    return true;
                                }
                                break;
                            }
                            case 2: {
                                if(judge(num, fu, '*', i,  nums,  select)) {
                                    return true;
                                }
                                break;
                            }
                            case 3: {
                                if(judge(num, fu, '/', i,  nums,  select)){
                                    return true;
                                }
                                break;
                            }
                        }
                    }
                }
                select.remove(i);
            }
        }
        return false;
    }

    public boolean judge(Stack<String> num, Stack<Character> fus, char fu, int index, int[] nums,  Set<Integer> select) {
        Stack<String> new_num = new Stack<>();
        new_num.addAll(num);
        new_num.push(String.valueOf(nums[index]));
        Stack<Character> new_fu = new Stack<>();
        new_fu.addAll(fus);
        new_fu.push(fu);
        boolean flag = check(nums,select, new_num, new_fu);
        if(flag) return true;
        new_num = new Stack<>();
        new_num.addAll(num);
        String value = new_num.pop();
        new_fu = new Stack<>();
        new_fu.addAll(fus);
        new_num.push(process(value, String.valueOf(nums[index]),fu));
        flag =  check(nums,select, new_num, new_fu);
        if(flag) return true;
        return false;
    }

    public boolean judge(String value) {
        if(value.contains("/")) {
            String[] v = value.split("/");
            int v1 = Integer.valueOf(v[0]);
            int v2 = Integer.valueOf(v[1]);
            if(v2==0) return false;
            return v1%v2==0&&v1/v2==24;
        }
        return "24".equals(value);
    }

    public String process(String a, String b, char fu){
        if(!a.contains("/")&&!b.contains("/")) {
            int n1 = Integer.parseInt(a);
            int n2 = Integer.parseInt(b);
            switch (fu) {
                case '+': return String.valueOf(n1+n2);
                case '-': return String.valueOf(n1-n2);
                case '*': return String.valueOf(n1*n2);
                case '/': return n1 + "/"+n2;
            }
        }else if(a.contains("/")&&b.contains("/")) {
            String[] new_v = a.split("/");
            int a_v1 = Integer.parseInt(new_v[0]);
            int a_v2 = Integer.parseInt(new_v[1]);
            String[] v = b.split("/");
            int b_v1 = Integer.parseInt(v[0]);
            int b_v2 = Integer.parseInt(v[1]);
            switch (fu) {
                case '+' :{
                    int fm = a_v2*b_v2;
                    int fz = b_v2*a_v1 + b_v1*a_v2;
                    return fz + "/"+ fm;
                }
                case '-':{
                    int fm = a_v2*b_v2;
                    int fz = b_v2*a_v1 - b_v1*a_v2;
                    return fz + "/"+ fm;
                }
                case '*':{
                    int fm = a_v2*b_v2;
                    int fz = a_v1*a_v1;
                    return fz + "/"+ fm;
                }
                case '/':{
                    int fz = a_v1*b_v2;
                    int fm = a_v2*b_v1;
                    return fz + "/"+ fm;
                }
            }
        }else if(!a.contains("/")){
            String[] strings = b.split("/");
            int fz = Integer.parseInt(strings[0]);
            int fm = Integer.parseInt(strings[1]);
            int v = Integer.parseInt(a);
            switch (fu) {
                case '+' :{
                    return v*fm+fz + "/" +fm;
                }
                case '-': {
                    return v*fm-fz+"/"+fm;
                }
                case '*':{
                    return v*fz+"/"+fm;
                }
                case '/':{
                    return v*fm+"/"+fz;
                }
            }
        }else {
            String[] strings = a.split("/");
            int fz = Integer.parseInt(strings[0]);
            int fm = Integer.parseInt(strings[1]);
            int v = Integer.parseInt(b);
            switch (fu) {
                case '+' :{
                    return v*fm+fz + "/" +fm;
                }
                case '-': {
                    return fz-v*fm+"/"+fm;
                }
                case '*':{
                    return v*fz+"/"+fm;
                }
                case '/':{
                    return fz+"/"+fm*v;
                }
            }
        }
        return "";
    }
}
