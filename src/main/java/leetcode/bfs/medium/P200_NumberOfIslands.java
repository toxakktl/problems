package leetcode.bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class P200_NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int counter = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(grid, visited, queue);
                    counter++;
                }
            }
        }
        return counter;
    }

    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};

    private void bfs(char[][] grid, boolean[][] visited, Queue<int[]> queue){
        int m = grid.length;
        int n = grid[0].length;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir: dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
