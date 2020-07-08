package chenjie.leetcode.tree;

public class SegmentTree {
    private int[] data;
    private int[] tree;

    public SegmentTree() {
    }

    public SegmentTree(int[] arr) {
        this.data = arr;
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = new int[arr.length * 4];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
        }
        int leftChild = 2*treeIndex + 1;
        int rightChild = 2 * treeIndex + 2;

        int mid =  l + (r - l ) /2;

        buildSegmentTree(leftChild, l, mid);
        buildSegmentTree(rightChild, mid + 1, r);
        tree[treeIndex] = tree[leftChild] + tree[rightChild];
    }
}
