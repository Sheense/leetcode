package sheen.leetcode.DisjointSetUnion;

/**
 * @Classname 甲板上的战舰
 * @Date 2021/12/18 3:55 下午
 * @Created by sheen
 * @Description TODO
 */
public class 甲板上的战舰 {
    public int countBattleships(char[][] board) {
        UnionSet unionSet = new UnionSet(board);
        int len = board[0].length;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'X') {
                    if(i - 1 >= 0 && board[i-1][j] == 'X') {
                        unionSet.union(i * len + j, (i - 1) * len + j);
                    }

                    if(j - 1 >= 0 && board[i][j - 1] == 'X') {
                        unionSet.union(i * len + j, i * len + j + 1);
                    }
                }
            }
        }
        return unionSet.getResult();
    }

    public static class UnionSet{
        private int set[];
        private char[][] board;
        public UnionSet(char[][] board) {
            set = new int[board.length * board[0].length];
            for(int i = 0; i < set.length; i++) {
                set[i] = i;
            }
            this.board = board;
        }

        public int findRoot(int i) {
            while (set[i] != i) {
                i = set[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int rootI = findRoot(i);
            int rootJ = findRoot(j);
            if(rootI != rootJ) {
                update(j, rootI);
            }
        }

        private void update(int j, int root) {
            while (set[j] != j) {
                int item = set[j];
                set[j] = root;
                j = item;
            }
            set[j] = root;
        }

        public int getResult() {
            int res = 0;
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    int key = i * board[0].length + j;
                    if(board[i][j] == 'X' && set[key] == key) {
                        res ++;
                    }
                }
            }
            return res;
        }
    }
}
