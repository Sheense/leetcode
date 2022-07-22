package sheen.leetcode.greedyAlgorithm;

//排序+贪心
public class 重构字符串 {

    public static void main(String[] args) {
        重构字符串 s = new 重构字符串();
        System.out.println(s.reorganizeString("vvvlo"));
    }
    public String reorganizeString(String S) {
        int [] arr = new int[26];
        int [] w = new int[26];
        for(int i=0;i<w.length;i++) {
            w[i] = i;
        }
        for(int i=0;i<S.length();i++) {
            arr[S.charAt(i)-'a']++;
        }
        String res ="";
        while(true) {
            sort(0,arr.length-1,w,arr);
            if(arr[0]==0) break;
            res += String.valueOf((char)(w[0]+'a'));
            arr[0]--;
            for(int i=1;i<arr.length;i++) {
                if(arr[i]!=0) {
                    while(arr[i]!=0&&arr[0]!=0) {
                        res += String.valueOf((char)(w[i]+'a'));
                        arr[i]--;
                        res += String.valueOf((char)(w[0]+'a'));
                        arr[0]--;
                    }
                }
            }
            if(arr[0]!=0) return "";
        }
        return res;
    }

    public void sort(int start, int end, int[]w,int[] arr) {
        if(start>=end) return;
        int left = start;
        int right = end;
        int key = arr[left];
        int wei = w[left];
        while(left<right) {
            while(left<right&&key>=arr[right]) right--;
            arr[left] = arr[right];
            w[left] = w[right];
            while(left<right&&key<=arr[left]) left++;
            arr[right] = arr[left];
            w[right] = w[left];
        }
        arr[left] = key;
        w[left] = wei;
        sort(start,left-1,w,arr);
        sort(left+1,end,w,arr);
    }
}
