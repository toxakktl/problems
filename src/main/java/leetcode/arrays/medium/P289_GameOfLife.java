package leetcode.arrays.medium;

public class P289_GameOfLife {

    public static void gameOfLife1(int[][] board) {
        if (board == null || board.length == 0)
            return;
        int N = board.length;
        int M = board[0].length;
        int[][] next = new int[N][M];
        int[][] dirs = {{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1},{0,-1}};
        for (int i = 0; i < N;i++){
            for (int j = 0; j < M;j++) {
                int liveCount = 0;
                for (int[] dir: dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || y < 0 || x >= N || y >= M)
                        continue;
                    if (board[x][y] == 1)
                        liveCount++;
                }
                if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) {
                    next[i][j] = 0;
                } else if (board[i][j] == 1 && (liveCount == 2 || liveCount == 3)) {
                    next[i][j] = 1;
                } else if (board[i][j] == 0 && liveCount == 3) {
                    next[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = next[i][j];
            }
        }
    }

    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;
        int N = board.length;
        int M = board[0].length;
        for (int i = 0; i < N;i++){
            for (int j = 0; j < M;j++) {
                int liveCount = countLiveNeighbors(board, i, j, N, M);
                if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) {
                    board[i][j] = -1;
                }
                if (board[i][j] == 0 && liveCount == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int row = 0; row < N; row++){
            for (int col = 0; col < M; col++){
                if (board[row][col] > 0)
                    board[row][col] = 1;
                else
                    board[row][col] = 0;
            }
        }
    }

    private static int countLiveNeighbors(int[][] board, int i, int j, int N, int M) {
        int liveCount = 0;
        int[][] dirs = {{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1},{0,-1}};
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x >= N || y >= M || Math.abs(board[x][y]) != 1)
                continue;
            if (Math.abs(board[x][y]) == 1)
                liveCount++;
        }
        return liveCount;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1}, {0,0,0}};
        gameOfLife(board);
    }
}
