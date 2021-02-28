package chenjie.leetcode.graph;

import org.junit.Test;

import java.util.Arrays;

public class FloydWarshall {
    public int[][] flodwarshall(int[][] weightedGraph, int n) {
        int[][] dist = new int[n][n];
        Integer[][] edgeTo = new Integer[n][n];
        for (int i = 0; i < edgeTo.length; i++) {
            for (int j = 0; j < edgeTo[0].length; j++) {
                dist[i][j] = weightedGraph[i][j];
                if (i != j && weightedGraph[i][j] < Integer.MAX_VALUE) {
                    edgeTo[i][j] = i;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0;  j < n; j++) {
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        edgeTo[i][j] = edgeTo[k][j];
                    }
                }
            }
        }
        Arrays.stream(edgeTo).forEach(c -> System.out.println(Arrays.toString(c)));
        System.out.println();
        return dist;
    }

    @Test
    /**
     [null, 2, 3, 4, 0]
     [3, null, 3, 1, 0]
     [3, 2, null, 1, 0]
     [3, 2, 3, null, 0]
     [3, 2, 3, 4, null]
     */
    public void test01() {
        int[][] graph = {
                {0, 3, 8, Integer.MAX_VALUE, -4},
                {Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 1, 7},
                {Integer.MAX_VALUE, 4, 0, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {2, Integer.MAX_VALUE, -5, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 0}
        };
        int[][] rs = flodwarshall(graph, 5);
        System.out.println("ans:");
        Arrays.stream(rs).forEach(c -> System.out.println(Arrays.toString(c)));
    }

    @Test
    public void test001() {
        int[] arr = {1, 2, 3};
        int[] arr1 = arr.clone();
        arr1[1] = 9;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
}
