package sheen.leetcode.array;

public class 种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        for(int i=0;i<flowerbed.length;i++) {
            if(i==0) {
                if(flowerbed[i]==0&&((i+1<flowerbed.length&&flowerbed[i+1]==0)||i+1<=flowerbed.length)){
                    n--;
                    flowerbed[i] = 1;
                }
            }else if(i==flowerbed.length-1){
                if(flowerbed[flowerbed.length-1]==0&&((i-1>=0&&flowerbed[i-1]==0)||i-1<0)){
                    n--;
                    flowerbed[flowerbed.length-1]=1;
                }
            }else if(flowerbed[i]==0&&flowerbed[i-1]==0&&flowerbed[i+1]==0) {
                n--;
                flowerbed[i]=1;
            }
            if(n==0) return true;
        }
        return false;
    }
}
