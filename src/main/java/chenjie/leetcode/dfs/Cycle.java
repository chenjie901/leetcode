package chenjie.leetcode.dfs;

public class Cycle {

    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.getV()];
        for (int s = 0; s < G.getV(); s++) {
            if (!marked[s]) {
                dfs(G, s, s);
            }
        }
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                System.out.printf("marked: u:%d, v:%d w: %d\n", u, v, w);
                dfs(G, w, v);
            } else if (w != u) {
                System.out.printf("uw: u:%d, v:%d w: %d\n", u, v, w);
                hasCycle = true;
            } else if (w == u) {
                System.out.printf("eq: u:%d, v:%d w: %d\n", u, v, w);
            } else {
                System.out.println("hahah");
            }


        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
