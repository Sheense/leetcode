package sheen.leetcode.array;

/**
 * @Classname 拆炸弹
 * @Date 2022/9/24 2:39 下午
 * @Created by sheen
 * @Description TODO
 */
public class 拆炸弹 {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        for(int i = 0; i < code.length; i++) {
            if(k > 0) {
                int count = k;
                int index = i + 1;
                while (count--!=0) {
                    res[i] += code[index % code.length];
                    index++;
                }
            }else if(k < 0) {
                int count = k;
                int index = i - 1;
                while (count++!=0) {
                    res[i] += code[index < 0 ? index + code.length : index];
                    index--;
                }
            }else {
                res[i] = 0;
            }
        }
        return res;
    }
}
