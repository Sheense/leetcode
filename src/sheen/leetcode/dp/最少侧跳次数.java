package sheen.leetcode.dp;

public class 最少侧跳次数 {
    public static void main(String[] args) {
        最少侧跳次数 s = new 最少侧跳次数();
        System.out.println(s.minSideJumps(new int[]{0,1,2,3,0}));
    }
    public int minSideJumps(int[] obstacles) {
        int[] arr = new int[3];
        int MAX = Integer.MAX_VALUE;
        for(int i=0;i<obstacles.length;i++) {
            if(i == 0) {
                switch (obstacles[i]){
                    case 0 : {
                        arr = new int[]{1, 0, 1};
                        break;
                    }
                    case 1 : {
                        arr = new int[]{MAX, 0, 1};
                        break;
                    }
                    case 3 : {
                        arr = new int[]{1 , 0 , MAX};
                        break;
                    }
                }
            }else {
                switch (obstacles[i]) {
                    case 0: {
                        if (arr[0] == MAX)  arr[0] = Math.min(arr[1], arr[2])+1;
                        else if(arr[1] == MAX) arr[1] = Math.min(arr[0], arr[2])+1;
                        else if(arr[2] == MAX) arr[2] = Math.min(arr[0], arr[1])+1;
                        break;
                    }
                    case 1: {
                        arr[0] = MAX;
                        if(arr[1] == MAX) arr[1] = arr[2] + 1;
                        else if(arr[2] == MAX) arr[2] = arr[1] + 1;
                        break;
                    }
                    case 2: {
                        arr[1] = MAX;
                        if(arr[2] == MAX) arr[2] = arr[0] + 1;
                        else if(arr[0] == MAX) arr[0] = arr[2] + 1;
                        break;
                    }
                    case 3: {
                         arr[2] = MAX;
                        if(arr[0] == MAX) arr[0] = arr[1] + 1;
                        else if(arr[1] == MAX) arr[1] = arr[0] + 1;
                         break;
                    }
                }
            }
        }
        return Math.min(Math.min(arr[0], arr[1]), arr[2]);
    }
}
