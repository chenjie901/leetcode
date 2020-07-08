package chenjie.leetcode.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Color {

    int[] color ;
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int m;

    @Test
    public void test001() {
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 2, 3, 4));
        graph.put(2, Arrays.asList(0, 1, 3));
        graph.put(3, Arrays.asList(1, 2, 4));
        graph.put(4, Arrays.asList(1, 3));
        color(3);
    }
    int[] color( int m) {
        color = new int[graph.size()];
        this.m  = m;
        backtrack(0);
        return color;
    }

    public void backtrack( int index) {
        if (index == graph.size()) {
            System.out.println(Arrays.toString(color));
            return;
        }

        for (int i = 1; i <= m; i++) {
            color[index] = i;
            if (check(index)) {
                backtrack(index + 1);
            }
            color[index] = 0;
        }
    }

    public boolean check(int index) {
        List<Integer> adj = graph.get(index);
        for (Integer v : adj) {
            if (color[v] == color[index]) {
                return false;
            }
        }

        return true;
    }

}
