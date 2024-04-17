package sheen.leetcode.greedyAlgorithm;

/**
 * @Classname 修改后的最大二进制字符串
 * @Date 2024/4/10 00:14
 * @Created by sheen
 * @Description TODO
 */
public class 修改后的最大二进制字符串 {
    public String maximumBinaryString(String binary) {
        char[] cs = binary.toCharArray();
        int j = 0;
        for(int i = 0; i < cs.length; i++) {
            if(cs[i] == '0') {
                while (j <= i || (j < cs.length && cs[j] == '1')) {
                    j++;
                }

                if(j < cs.length) {
                    cs[i] = '1';
                    cs[j] = '1';
                    cs[i + 1] = '0';
                }
            }
        }

        return String.valueOf(cs);
    }
}
