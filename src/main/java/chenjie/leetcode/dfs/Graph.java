package chenjie.leetcode.dfs;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    int V;
    int E;
    List<Integer>[] adj;

    public Graph(int v) {
        V = v;
        adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
