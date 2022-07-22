package sheen.leetcode.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 迷你语法分析器
 * @Date 2022/4/15 12:30 上午
 * @Created by sheen
 * @Description TODO
 */
public class 迷你语法分析器 {
    public static void main(String[] args) {
        迷你语法分析器 s = new 迷你语法分析器();
        s.deserialize("[123,456,[788,799,833],[[]],10,[]]");
    }
    public NestedInteger deserialize(String s) {
        if(s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Sign sign = recall(s, 1);
        return sign.nestedInteger;
    }

    public Sign recall(String s, int index) {
        NestedInteger integer = new NestedInteger();
        while (index < s.length() && s.charAt(index) != ']') {
            if(s.charAt(index) == ',') {
                index++;
            }
            int start = index;
            if(s.charAt(start) == '[') {
                Sign sign = recall(s, start + 1);
                index = sign.index + 1;
                integer.add(sign.nestedInteger);
            }else {
                while (index < s.length() && s.charAt(index) != ',' && s.charAt(index) != ']') {
                    index++;
                }
                NestedInteger item = new NestedInteger(Integer.parseInt(s.substring(start, index)));
                integer.add(item);
            }
        }

        return new Sign(integer, index);
    }

    public static class Sign{
        NestedInteger nestedInteger;
        int index;

        public Sign(NestedInteger integer, int index) {
            this.nestedInteger = integer;
            this.index = index;
        }
    }

    public static class NestedInteger {
        public NestedInteger(){}
        public NestedInteger(int value) {
        }
        public boolean isInteger() {
            return false;
        }
        public Integer getInteger() {return  0;}
        public void setInteger(int value){}
        public void add(NestedInteger ni) {}
        public List<NestedInteger> getList(){
            return new ArrayList<>();
        }
    }
}
