package chenjie.leetcode.graph;

import java.util.*;

public class MST {

    class Edge implements Comparable<Edge> {
        int u;
        int v;
        int weight;

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int other(int vertex) {
            if (vertex == v) {
                return u;
            } else {
                return v;
            }
        }

        public int eight() {
            return u;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return u == edge.u &&
                    v == edge.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v);
        }

        @Override
        public String toString() {
            return String.format("(u:%d v:%d w:%d)", u, v, weight);
        }
    }

    Map<Integer, List<Edge>> graph = new HashMap<>();
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    Map<Integer, Boolean> marked = new HashMap<>();
    List<Edge> mst = new LinkedList<>();

    private void addToGraph(int v, Edge edge) {
        List<Edge> adj = graph.get(v);
        if (adj == null) {
            adj = new LinkedList<>();
            adj.add(edge);
            graph.put(v, adj);
        } else {
            adj.add(edge);
        }
    }

    public MST(int[][] edges, int[] weights) {
        for (int i = 0; i < edges.length; i++) {
            Edge edge = new Edge(edges[i][0], edges[i][1], weights[i]);
            addToGraph(edges[i][0], edge);
            addToGraph(edges[i][1], edge);
        }

        visit(0);
        while (!pq.isEmpty()) {
            Edge min = pq.poll();
            int u = min.eight();
            int v = min.other(u);
            if (marked.containsKey(u) && marked.containsKey(v)) {
                continue;
            }
            mst.add(min);
            if (!marked.containsKey(u)) {
                visit(u);
            }

            if (!marked.containsKey(v)) {
                visit(v);
            }
        }
    }

    public void visit(int v) {
        marked.put(v, true);
        for (Edge e : graph.get(v)) {
            if (!marked.containsKey(e.other(v))) {
                pq.offer(e);
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Edge e : mst) {
            sb.append(String.format("(%d %d %d)\n", e.u, e.v, e.weight));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0}
        };

        int[] weiht = {1, 2, 3, 4};

        MST mst = new MST(graph, weiht);
        System.out.println(mst);
    }
}
