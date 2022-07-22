package sheen.leetcode.bitOperation;

public class 制作m束花所需的最少天数 {

    public static void main(String[] args) {
        制作m束花所需的最少天数 s = new 制作m束花所需的最少天数();
        System.out.println(s.minDays(new int[]{1,10,2,9,3,8,4,7,5,6},4,2));
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++) {
            if(bloomDay[i]>max) {
                max = bloomDay[i];
            }
        }
        int res = -1;
        int start =1;
        int end = max;
        while(start<=end){
            int mid = (start+end)/2;
            int size = m;
            int i = 0;
            boolean flag = false;
            while (i<bloomDay.length) {
                if(bloomDay[i]<=mid) {
                    int l = i;
                    int r = i;
                    while(r<bloomDay.length&&bloomDay[r]<=mid) {
                        if(r-l+1==k) {
                            size--;
                            break;
                        }
                        r++;
                    }
                    i = r;
                }
                if(size==0) {
                    flag = true;
                    break;
                }
                i++;
            }
            if(flag){
                res = res==-1?mid:(res>mid?mid:res);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
}
