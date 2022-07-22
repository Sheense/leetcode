package sheen.leetcode.number;

public class 卡牌分组 {
    public static void main(String[] args) {
        卡牌分组 s = new 卡牌分组();
        System.out.println(s.hasGroupsSizeX(new int[]{1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3}));
    }
    public boolean hasGroupsSizeX(int[] deck) {
        int [] puke = new int[1000];
        for(int i=0;i<deck.length;i++) {
            puke[deck[i]]++;
        }
        int yueshu = 0;
        for(int i=0;i<puke.length-1;i++) {
            if(puke[i]==0)continue;
            if(yueshu==0) yueshu = puke[i];
            yueshu = god(Math.max(puke[i], yueshu), Math.min(puke[i],yueshu));
            if(yueshu==1) return false;
        }
        return true;
    }
    public int god(int x , int y) {
        int v = x%y;
        if(v==0) return y;
        return god(y, v);
    }
}
