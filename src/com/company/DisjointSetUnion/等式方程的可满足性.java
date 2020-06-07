package com.company.DisjointSetUnion;


import com.company.util.ArrayUtils;

public class 等式方程的可满足性 {
    public static void main(String[] args) {
        等式方程的可满足性 s= new 等式方程的可满足性();
        System.out.println(s.equationsPossible(new String[]{"f==a","a==b","f!=e","a==c","b==e","c==f"}));
    }
    public boolean equationsPossible(String[] equations) {
        int[] set = new int[26];
        for(int i=0;i<26;i++) {
            set[i] = i;
        }
        for(int i=0;i<equations.length;i++) {
            if(equations[i].charAt(1)=='!')continue;
            int a = equations[i].charAt(0)-'a';
            int b = equations[i].charAt(3)-'a';
            if(a==b) continue;
            int root1 = findRoot(set,a);
            int root2 = findRoot(set,b);
            if(root1!=root2) {
                set[root1] = root2;
            }
        }
        for(int i=0;i<equations.length;i++) {
            if(equations[i].charAt(1)=='=') continue;
            int a = equations[i].charAt(0) - 'a';
            int b = equations[i].charAt(3) - 'a';
            if(findRoot(set,a)==findRoot(set,b)) return false;
        }
        return true;
    }
    public int findRoot(int[] set, int index) {
        while(set[index]!=index) {
            index = set[index];
        }
        return index;
    }

}
