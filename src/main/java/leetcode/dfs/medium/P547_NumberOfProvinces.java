package leetcode.dfs.medium;

public class P547_NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0)
            return 0;
        int N = isConnected.length;
        boolean[] visited = new boolean[N];
        int provinces = 0;

        for (int i = 0; i < N; i++){
            if (!visited[i]) {
                provinces++;
                dfs(i, isConnected, visited);
            }
        }
        return provinces;
    }

    private void dfs(int city, int[][] isConnected, boolean[] visited) {
        visited[city] = true;
        for (int i = 0; i < isConnected[city].length; i++) {
            if (isConnected[city][i] == 1 && !visited[i])
                dfs(i, isConnected, visited);
        }
    }
}
