package chenjie.leetcode.dfs;

import org.junit.Assert;
import org.junit.Test;

public class CycleTest {

    @Test
    public void testHasCycle() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);

        Cycle cycle = new Cycle(graph);
        Assert.assertTrue(cycle.hasCycle());
    }
}
