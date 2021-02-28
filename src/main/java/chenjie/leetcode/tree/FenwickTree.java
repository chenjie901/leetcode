package chenjie.leetcode.tree;

import java.util.Arrays;

public class FenwickTree {
    int[] bit;
    int n;

    public FenwickTree(int[] arr) {
        n = arr.length;
        bit = new int[n];
        for (int i = 0; i < arr.length; i++) {
            add(i, arr[i]);
        }
        System.out.println(Arrays.toString(bit));
    }

    public int sum(int r) {
        int ret = 0;
        for (; r >= 0; r = (r & (r + 1)) - 1) {
            ret += bit[r];
        }
        return ret;
    }

    public int sum(int l, int r) {
        return sum(r) - sum(l - 1);
    }

    void add(int idx, int delta) {
        System.out.printf("idx : %d\t", idx);
        for (; idx < n; idx = idx | (idx + 1)) {
            System.out.printf("----> %d\t", idx);
            bit[idx] += delta;
        }
        System.out.println();
    }
}
