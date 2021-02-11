package chenjie.leetcode.graph;

import org.junit.Test;

import java.util.*;

public class SCC {
    TopoSort topoSort = new TopoSort();

    public List<List<Integer>> scc(List<Integer>[] graph) {
        int[] visited = new int[graph.length];
        List<Integer> path = topoSort.topoSortDfs(graph);

        List<List<Integer>> ans = new LinkedList<>();
        List<Integer>[] transformedGraph = transform(graph);

        Arrays.fill(visited, 0);

        for (int v : path) {
            if (visited[v] == 0) {
                List<Integer> component = new LinkedList<>();
                dfs(transformedGraph, component, v, visited);
                ans.addAll(Collections.singleton(new LinkedList<>(component)));
                component.clear();
            }
        }
        return ans;
    }

    private void dfs(List<Integer>[] graph, List<Integer> component, int root, int[] visited) {
        visited[root] = 1;
        for (int v : graph[root]) {
            if (visited[v] == 1) {
                continue;
            }
            dfs(graph, component, v, visited);
        }
        component.add(root);
    }

    private List<Integer>[] transform(List<Integer>[] graph) {
        List<Integer>[] graph1 = new List[graph.length];
        for (int i = 0; i < graph1.length; i++) {
            graph1[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; i++) {
            for (int v : graph[i]) {
                graph1[v].add(i);
            }
        }
        return graph1;
    }

    @Test
    public void test001() {
        List<Integer>[] graph = new List[6];
        graph[0] = Arrays.asList(1, 2);
        graph[1] = Arrays.asList(3);
        graph[2] = Arrays.asList(3);
        graph[3] = Arrays.asList(2);
        graph[4] = Arrays.asList(5);
        graph[5] = Arrays.asList();

        List<List<Integer>> ans = scc(graph);
        System.out.println("----");
        ans.stream().forEach(a -> System.out.println(a));

    }
}
