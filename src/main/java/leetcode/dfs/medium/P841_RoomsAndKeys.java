package leetcode.dfs.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class P841_RoomsAndKeys {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null) return true;
        int N = rooms.size();
        boolean[] visited = new boolean[N];

        dfs(0, rooms, visited);

        for (int i = 0; i < visited.length; i++){
            if (!visited[i])
                return false;
        }
        return true;
    }

    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int neighbour: graph.get(node)) {
            if (!visited[neighbour])
                dfs(neighbour, graph, visited);
        }
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack<>();
        dfs.add(0);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!dfs.isEmpty()) {
            int i = dfs.pop();
            for (int key: rooms.get(i)) {
                if (!seen.contains(key)) {
                    dfs.add(key);
                    seen.add(key);
                    if (rooms.size() == seen.size())
                        return true;
                }
            }
        }
        return rooms.size() == seen.size();
    }
}
