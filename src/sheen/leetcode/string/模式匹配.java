package sheen.leetcode.string;

public class 模式匹配 {

    public static void main(String[] args) {
        模式匹配 s = new 模式匹配();
        System.out.println(s.patternMatching("bb","thuhrh"));
    }
    public boolean patternMatching(String pattern, String value) {
        if(pattern.equals("")&&value.length()>0) return false;
        int aNum = 0;
        int bNum = 0;
        for(int i=0;i<pattern.length();i++) {
            if(pattern.charAt(i)=='a') aNum++;
            if(pattern.charAt(i)=='b') bNum++;
        }
        if(value.equals("")){
            if(aNum>0&&bNum>0)return false;
            else return true;
        }
        if(aNum==0) {
            for(int blen = 1;blen<=value.length()/bNum;blen++) {
                String bString = "";
                String string = value.substring(0,blen);
                boolean res = true;
                for(int i=1;i<=bNum;i++) {
                    bString+=string;
                }
                if(res&&bString.equals(value)) return true;
            }
        }else {
            for(int alen=0;alen<=value.length()/aNum;alen++) {
                int blen = bNum==0?0:(value.length()-aNum*alen)/bNum;
                if(blen*bNum+alen*aNum!=value.length()) continue;
                if(blen==0&&alen==0) continue;
                boolean res = true;
                String aString = "";
                String bString = "";
                int index = 0;
                for(int j=0;j<pattern.length();j++) {
                    if(pattern.charAt(j)=='a'&&alen!=0) {
                        if(index+alen<=value.length()) {
                            String string = value.substring(index,index+alen);
                            if(string.equals(aString)||aString.equals("")) {
                                aString = string;
                                index+=alen;
                            }else {
                                res = false;
                                break;
                            }
                        }else {
                            res = false;
                            break;
                        }
                    }

                    if(pattern.charAt(j)=='b'&&blen!=0) {
                        if(index+blen<=value.length()) {
                            String string = value.substring(index,index+blen);
                            if(string.equals(bString)||bString.equals("")) {
                                bString = string;
                                index+=blen;
                            }else {
                                res = false;
                                break;
                            }
                        }else {
                            res = false;
                            break;
                        }
                    }
                }
                if(res) return true;
            }
        }
        return false;
    }
}
