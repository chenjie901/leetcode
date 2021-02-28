package chenjie.leetcode.tree;

public class FenwickTree2D {
    int n;
    int m;
    int[][] bit;

    public FenwickTree2D(int[][] arr) {
        n = arr.length;
        m = arr[0].length;
        bit = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                add(i, j, arr[i][j]);
            }
        }
    }

    public int sum(int x, int y) {
        int ret = 0;
        for (int i = x; i >= 0; i = (i & (i + 1)) - 1) {
            for (int j = y; j >=0; j = (j & (j + 1)) - 1) {
                ret += bit[i][j];
            }
        }
        return ret;
    }

    public int sum(int x1, int y1, int x2, int y2) {
        return sum(x2, y2) - sum(x2 , y1 - 1) - sum(x1 - 1, y2) + sum(x1 - 1, y1 - 1);
    }

    void add(int x, int y, int delta) {
        for (int i = x; i < n; i = i | (i + 1)) {
            for (int j = y; j < m; j = j | (j + 1)) {
                bit[i][j] += delta;
            }
        }
    }
}
