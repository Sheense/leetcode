package com.company.string;

import java.util.ArrayList;
import java.util.List;

public class 兰顿蚂蚁 {
    public static void main(String[] args) {
        兰顿蚂蚁 s = new 兰顿蚂蚁();
        System.out.println(s.printKMoves(0));
    }
    public List<String> printKMoves(int K) {
        List<StringBuilder> res = new ArrayList<>();
        res.add(new StringBuilder().append("_"));
        char dir = 'R';
        int x = 0;
        int y = 0;
        while (K>0) {
            if (res.get(x).charAt(y)=='_') {
                res.get(x).setCharAt(y, 'X');
                switch (dir) {
                    case 'R': {
                        dir = 'D';
                        x++;
                        break;
                    }
                    case 'D': {
                        dir = 'L';
                        y--;
                        break;
                    }
                    case 'L': {
                        dir = 'U';
                        x--;
                        break;
                    }
                    case 'U': {
                        dir = 'R';
                        y++;
                        break;
                    }
                }
            }else {
                res.get(x).setCharAt(y, '_');
                switch (dir) {
                    case 'R': {
                        dir = 'U';
                        x--;
                        break;
                    }
                    case 'D': {
                        dir = 'R';
                        y++;
                        break;
                    }
                    case 'L': {
                        dir = 'D';
                        x++;
                        break;
                    }
                    case 'U': {
                        dir = 'L';
                        y--;
                        break;
                    }
                }
            }

            if(x < 0) {
                StringBuilder head = new StringBuilder();
                for(int i = 0; i<res.get(x+1).length();i++) {
                    head.append("_");
                }
                List<StringBuilder> copy = new ArrayList<>();
                copy.add(head);
                copy.addAll(res);
                x = 0;
                res = copy;
            }else if(x>=res.size()) {
                StringBuilder last = new StringBuilder();
                for(int i = 0; i<res.get(x-1).length();i++) {
                    last.append("_");
                }
                List<StringBuilder> copy = new ArrayList<>();
                copy.addAll(res);
                copy.add(last);
                res = copy;
            }else if(y < 0) {
                for(int i=0;i<res.size();i++) {
                    res.set(i, new StringBuilder('_'+res.get(i).toString()));
                }
                y = 0;
            }else if(y>=res.get(x).length()){
                for(int i=0;i<res.size();i++) {
                    res.set(i, new StringBuilder(res.get(i).toString()+'_'));
                }
            }
            K--;
        }
        res.get(x).setCharAt(y, dir);
        List<String> ans = new ArrayList<>();
        for(int i=0;i<res.size();i++) {
            ans.add(res.get(i).toString());
        }
        return ans;
    }
}
