package leetcode.dfs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class P200_NumberOfIslands {
    /**
     * dfs solution
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int N = grid.length;
        int M = grid[0].length;
        int counter = 0;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    counter++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return counter;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
            return;
        if (grid[i][j] != '1' || visited[i][j])
            return;
        dfs(i-1, j, grid, visited);
        dfs(i+1, j, grid, visited);
        dfs(i, j-1, grid, visited);
        dfs(i, j+1, grid, visited);
    }

    /**
     * bfs
     * @param grid
     * @param i
     * @param j
     */
    private void bfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0,1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        while (!queue.isEmpty()) {
            int[] crd = queue.poll();
            for (int[] dir: dirs){
                int x = crd[0] + dir[0];
                int y = crd[1] + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                    queue.offer(new int[]{x,y});
                    grid[x][y] = '0';
                }
            }
        }
    }
}
