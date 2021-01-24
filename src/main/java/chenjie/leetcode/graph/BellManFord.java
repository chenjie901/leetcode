package chenjie.leetcode.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BellManFord {
    public int shortedPath(int[][] edges, int n, int s, int t) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph[edge[0]].add(edge[1]);
        }

        int[] dist = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE / 2;
        }
        dist[s] = 0;

        for (int[] edge : edges) {
            relax(dist, edge[0], edge[1], edge[2]);
        }
        System.out.println(Arrays.toString(dist));

        return dist[t];
    }

    private void relax(int[] dist, int u, int v, int w) {
        if (dist[v] > dist[u] + w) {
            dist[v] = dist[u] + w;
        }
    }

    @Test
    public void test001() {
        int[][] edges = {
                {0, 1, 6},
                {0, 2, 7},
                {1, 2, 8},
                {1, 3, 5},
                {1, 4, -4},
                {2, 4, 9},
                {2, 3, -3},
                {3, 1, -2},
                {4, 0, 2},
                {4, 3, 7}
        };
        System.out.println(shortedPath(edges, 5, 0, 3));

    }
}
