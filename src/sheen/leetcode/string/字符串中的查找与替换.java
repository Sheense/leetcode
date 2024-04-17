package sheen.leetcode.string;

/**
 * @Classname 字符串中的查找与替换
 * @Date 2023/8/15 00:49
 * @Created by sheen
 * @Description TODO
 */
public class 字符串中的查找与替换 {
    public static void main(String[] args) {
        字符串中的查找与替换 s = new 字符串中的查找与替换();
        //System.out.println(s.findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee","ffff"}));
        System.out.println(s.findReplaceString("vmokgggqzp", new int[]{3,5,1}, new String[]{"kg","ggq","mo"}, new String[]{"s","so","bfr"}));

    }
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        sort(0, indices.length - 1, indices, sources, targets);
        String res = "";
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if(i < indices.length && indices[i] == j) {
                if(s.substring(j, Math.min(j + sources[i].length(), s.length())).equals(sources[i])) {
                    res += targets[i];
                    j = j + sources[i].length();
                }else {
                    res += s.charAt(j);
                    j++;
                }
                i++;
            }else {
                res += s.charAt(j);
                j++;
            }
        }
        return res;
    }

    public void sort(int left, int right, int[] indices, String[] sources, String[] targets) {
        if(left >= right) {
            return;
        }
        int midIndice = indices[left];
        String  midSource = sources[left];
        String midTarget = targets[left];
        int begin = left;
        int after = right;
        while (begin < after) {
            while (begin < after && midIndice <= indices[after]) after--;
            indices[begin] = indices[after];
            sources[begin] = sources[after];
            targets[begin] = targets[after];
            while (begin < after && midIndice >= indices[begin]) begin++;
            indices[after] = indices[begin];
            sources[after] = sources[begin];
            targets[after] = targets[begin];
        }
        indices[begin] = midIndice;
        sources[begin] = midSource;
        targets[begin] = midTarget;

        sort(left, begin - 1, indices, sources, targets);
        sort(begin + 1, right, indices, sources, targets);

    }
}
