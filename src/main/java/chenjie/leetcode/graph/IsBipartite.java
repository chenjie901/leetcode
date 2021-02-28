package chenjie.leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

public class IsBipartite {
    //785. 判断二分图
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        int[] visited = new int[v];

        for (int i = 0; i < v; i++) {
            if (visited[i] == 1) {
                continue;
            }
            color[i] = 1;
            visited[i] = 1;
            if (!dfs(graph, color, visited, i)) {
                return false;
            }
        }

        return true;
    }

    protected boolean dfs(int[][] graph, int[] color, int[] visited, int start) {

        for (int v : graph[start]) {
            if (visited[v] == 0) {
                color[v] = -color[start];
                visited[v] = 1;
                if (!dfs(graph, color, visited, v)) {
                    return false;
                }
            } else if (color[start] == color[v]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test01() {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        Assert.assertFalse(isBipartite(graph));
    }
}
