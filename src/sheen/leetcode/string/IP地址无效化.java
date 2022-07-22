package sheen.leetcode.string;

/**
 * @Classname IP地址无效化
 * @Date 2022/6/21 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class IP地址无效化 {
    public String defangIPaddr(String address) {
        String res = "";
        for(int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.') {
                res += "[.]";
            }else {
                res += address.charAt(i);
            }
        }
        return res;
    }
}
