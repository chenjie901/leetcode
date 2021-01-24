package chenjie.leetcode.graph;

import org.junit.Test;

import java.util.*;

public class TopoSort {

    public List<Integer> topoSortDfs(List<Integer>[] graph) {
        List<Integer> path = new LinkedList<>();
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                dfs(graph, path, visited, i);
            }
        }

        Collections.reverse(path);

        System.out.println(path);
        return path;
    }

    public List<Integer> topoSort(List<Integer>[] graph) {
        int[] indegree = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int v : graph[i]) {
                indegree[v]++;
            }
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans.add(cur);
            for (int v : graph[cur]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        System.out.println(ans);
        return ans;
    }

    private void dfs(List<Integer>[] graph, List<Integer> path, int[] visited, int root) {
        visited[root] = 1;
        for (int v : graph[root]) {
            if (visited[v] == 1) {
                continue;
            }
            dfs(graph, path, visited, v);
        }
        path.add(root);
    }

    @Test
    public void test001() {
        List<Integer>[] graph = new List[6];
        graph[0] = Arrays.asList(1, 2);
        graph[1] = Arrays.asList(3);
        graph[2] = Arrays.asList(3);
        graph[3] = Arrays.asList();
        graph[4] = Arrays.asList(5);
        graph[5] = Arrays.asList();

        topoSortDfs(graph);
        topoSort(graph);
    }
}
