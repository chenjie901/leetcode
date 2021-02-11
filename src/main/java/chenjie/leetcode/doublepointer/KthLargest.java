package chenjie.leetcode.doublepointer;

import java.util.PriorityQueue;

//703. 数据流中的第 K 大元素
class KthLargest {
    PriorityQueue<Integer> queue;
    int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        queue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > size) {
            queue.poll();
        }
        return queue.peek();
    }
}