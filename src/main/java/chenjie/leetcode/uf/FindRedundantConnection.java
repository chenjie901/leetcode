package chenjie.leetcode.uf;

public class FindRedundantConnection {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int N = edges.length + 1;
        UF uf = new UF(N);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[]{0, 0};
    }

    class UF {
        // 记录连通分量个数
        private int count;
        // 存储若干棵树
        private int[] parent;


        public UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /* 将 p 和 q 连通 */
        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return false;

            parent[rootQ] = rootP;

            count--;
            return true;
        }

        /* 判断 p 和 q 是否互相连通 */
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            // 处于同一棵树上的节点，相互连通
            return rootP == rootQ;
        }

        /* 返回节点 x 的根节点 */
        private int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }

        public int count() {
            return count;
        }
    }
}
