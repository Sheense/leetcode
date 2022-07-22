package sheen.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class 文本左右对齐 {

    public static void main(String[] args) {
        文本左右对齐 s = new 文本左右对齐();
        for(String string :s.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16)){
            System.out.println(string);
        }
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i<words.length) {
            List<String> line = new ArrayList<>();
            int length = 0;
            int trim = 0;
            while(i<words.length&&length+words[i].length()+trim<=maxWidth) {
                length += words[i].length();
                line.add(words[i++]);
                trim++;
            }
            trim = line.size() == 1 ? 1: line.size()-1;
            String item = "";
            int interval = (maxWidth - length)/trim;
            int yu = (maxWidth - length)%trim;
            int j = 0;
            while(trim-->0) {
                item += line.get(j++);
                if(i == words.length) {
                    if(j<line.size()){
                        item += " ";
                    }
                } else {
                    int q = 0;
                    if(yu>0) {
                        q = 1;
                        yu--;
                    }
                    for(int z = 0;z< interval+q;z++) {
                        item += " ";
                    }
                }
            }
            if(j<line.size()) {
                item += line.get(j);
            }
            if (i == words.length) {
                for(int z = item.length(); z<maxWidth;z++) {
                    item += " ";
                }
            }
            res.add(item);
        }
        return res;
    }
}
