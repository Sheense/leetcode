package sheen.leetcode.string;

import java.util.*;

/**
 * @Classname 花括号展开II
 * @Date 2023/3/7 12:48 上午
 * @Created by sheen
 * @Description TODO
 */
public class 花括号展开II {
    public static void main(String[] args) {
        花括号展开II s = new 花括号展开II();
        String test = "abc{{a,c},ab{a,dd},{i,o}a{a,q,v}b{a,c}}";
        System.out.println(s.braceExpansionII("{i,o}a{a,q,v}b{a,c}"));
    }
    public List<String> braceExpansionII(String expression) {
        Stack<List<String>> elements = new Stack<>();
        Stack<Character> fu = new Stack<>();
        int i = 0;
        while (i < expression.length()) {
            int start = i;
            String pre = "";
            //找出纯字母的元素
            while (i < expression.length() && expression.charAt(i) >= 'a'&& expression.charAt(i) <= 'z') {
                pre += expression.charAt(i);
                i++;
            }

            if(!pre.equals("")) {
                List<String> item = new ArrayList<>();
                item.add(pre);
                elements.push(item);
                //应对这种情况：{i,o}a
                if(start - 1 >= 0 && expression.charAt(start - 1) == '}') {
                    fu.push('*');
                }
            }

            // 应对这两种情况：a，{b,c}a，解析出a就结束了
            if(i >= expression.length()) {
                break;
            }

            if(expression.charAt(i) == '{') {
                //应对这种情况：a{a,q,v} 和 {i,o}{a,q,v}
                if(!pre.equals("") || (i - 1 >= 0 && expression.charAt(i - 1) == '}')) {
                    fu.push('*');
                }
                fu.push('{');
            }else if(expression.charAt(i) == ',') {
                //应对{a,a{b,c},{b,c}}中，a{b,c}的情况
                while (!fu.isEmpty() && fu.peek() == '*') {
                    fu.pop();
                    elements.push(multi(elements.pop(), elements.pop()));
                }
                fu.push(',');
            }else if(expression.charAt(i) == '}') {
                //遍历到和它匹配的的'{',计算这个集合的元素
                while (!fu.isEmpty() && fu.peek() != '{') {
                    char f = fu.pop();
                    if(f == ',') {
                        elements.push(and(elements.pop(), elements.pop()));
                    }else if(f == '*') {
                        elements.push(multi(elements.pop(), elements.pop()));
                    }
                }
                if(!fu.isEmpty()) {
                    fu.pop();
                }
            }
            i++;
        }

        //剩下一堆'*'的符号，例如：a{b,c}{b,d}
        while (!fu.isEmpty()) {
            fu.pop();
            elements.push(multi(elements.pop(), elements.pop()));
        }
        //去重
        Set<String> set = new HashSet<>(elements.pop());
        //排序
        List<String> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }

    public List<String> and(List<String> after, List<String> before){
        before.addAll(after);
        return before;
    }

    public List<String> multi(List<String> after, List<String> before) {
        List<String> newList = new ArrayList<>();
        for(String v1 : before) {
            for(String v2 : after) {
                newList.add(v1 + v2);
            }
        }

        return newList;
    }

    //1、表达式e1="a"，e2="{b,c}"看成列表，e1=List(a)，e2=List(b,c)
    //2、a{b,c}或者{a,b}{c,d}，我们看成乘法{a,b}*{c,d}，加一个符号'*'，方便栈计算
    //3、{c,d}我们看成List(c) + List(d)
    //4、那么从上面拆分，我们加可以直接理解成加法和乘法的运算式子，就是很普通栈运算，
    // 用两个栈搞定，一个放符号，一个放元素(每个元素是一个链表)，根据符号去放元素的栈拿元素计算
    //例如：表达式a{{b,c},e{f,g},{a,c}{b,c}c}，我们可以看成List(a) * (List(b,c) + List(e) * List(f,g) + List(a,c) * List(b,c) * List(c))

}
