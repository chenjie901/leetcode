package chenjie.leetcode.tree;

import java.util.Arrays;

public class FenwickTreeMin {
    int n;
    int[] bit;

    public FenwickTreeMin(int[] arr) {
        n = arr.length;
        bit = new int[n];
        Arrays.fill(bit, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            update(i, arr[i]);
        }
        System.out.println(Arrays.toString(bit));
    }

    public int getMin(int r) {
        int ret = Integer.MAX_VALUE;
        for (; r >= 0; r = (r & (r + 1)) - 1) {
            ret = Math.min(ret, bit[r]);
        }
        return ret;
    }


    void update(int idx, int val) {
        for(; idx < n; idx = idx | (idx + 1)) {
            bit[idx] = Math.min(bit[idx], val);
        }
    }
}
