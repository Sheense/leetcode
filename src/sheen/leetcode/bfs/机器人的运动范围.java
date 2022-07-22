package sheen.leetcode.bfs;

public class 机器人的运动范围 {

    public static void main(String[] args) {
        机器人的运动范围 s = new 机器人的运动范围();
        System.out.println(s.movingCount(2,3,1));
    }
    public int movingCount(int m, int n, int k) {
        int res =0;
        boolean[][] map = new boolean[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(map[i][j]){
                    continue;
                }

            }
        }
        return bfs(map,m,n,0,0,k);
    }

    public int bfs(boolean[][] map, int m,int n, int i, int j, int k) {
        int time = 1;
        if(!check(i,j,k)) return 0;
        map[i][j] = true;
        if(i-1>=0&&!map[i-1][j]){
            time += bfs(map,  m, n,  i-1,  j,  k);
        }
        if(j-1>=0&&!map[i][j-1]){
            time += bfs(map,  m, n,  i,  j-1,  k);
        }
        if(j+1<n&&!map[i][j+1]){
            time += bfs(map,  m, n,  i,  j+1,  k);
        }
        if(i+1<m&&!map[i+1][j]){
            time += bfs(map, m, n, i+1,  j,  k);
        }
        return time;
    }

    public boolean check(int i, int j,int k) {
        int all = 0;
        while(i/10!=0) {
            all+=i%10;
            i/=10;
        }
        all+=i;
        while(j/10!=0) {
            all+=j%10;
            j/=10;
        }
        all+=j;
        if(all>k) return false;
        else return true;
    }
}
