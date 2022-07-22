package sheen.leetcode.map;

public class 岛屿数量 {
    public static void main(String[] args) {
        岛屿数量 s = new 岛屿数量();
        char[][] map = {
                            {'1','1','1','1','0'},
                            {'1','1','0','1','0'},
                            {'1','1','0','0','0'},
                            {'0','0','0','0','0'}
        };
        System.out.println(s.numIslands(map));
    }

    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        boolean [][] map = new boolean[grid.length][grid[0].length];
        int num = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j]=='1'&&!map[i][j]) {
                    update(i,j,map,grid);
                    num++;
                }
            }
        }
        return num;
    }
    public void update(int i,int j, boolean[][] map,char[][] grid) {
        if(i<0||i>=map.length) return ;
        if(j<0||j>=map[0].length) return ;
        if(map[i][j]) return ;
        if(grid[i][j]=='0') return ;
        map[i][j] = true;
        update(i-1,j,map,grid);
        update(i,j-1,map,grid);
        update(i+1,j,map,grid);
        update(i,j+1,map,grid);
    }
}
