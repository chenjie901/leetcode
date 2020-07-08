package chenjie.leetcode.interval;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxDepth {

    @Test
    public void test001() {
        int[][] intervals = new int[][]{
                {3, 4},
                {5, 6},
                {1, 2}
        };
        System.out.println(getMaxIntervalOverlapCount(intervals));
    }

    @Test
    public void test002() {
        int[][] intervals = new int[][]{
                {1, 8},
                {2, 9},
                {5, 10}
        };
        System.out.println(getMaxIntervalOverlapCount(intervals));
    }

    public int getMaxIntervalOverlapCount(int[][] intervals) {
        int workers = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(intervals[0][1]);
        workers++;

        for (int i = 1; i < intervals.length; i++) {
            if(priorityQueue.peek() >= intervals[i][0]) {
                workers++;
            } else {
                priorityQueue.poll();
            }
            priorityQueue.add(intervals[i][1]);
        }
        return workers;
    }

    @Test
    public void test003() {
        int[][] intervals = new int[][]{
                {1, 2},
                {3, 4},
                {5, 10},
                {6, 11}
        };
        System.out.println(findMinArrowShots(intervals));
    }

    public int findMinArrowShots(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int cnt = 1;
        int lastEnd = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > lastEnd) {
                cnt++;
                lastEnd = intervals[i][1];
            }
        }
        return cnt;
    }
}
