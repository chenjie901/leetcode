package chenjie.leetcode.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] prerequery : prerequisites) {
            graph[prerequery[1]].add(prerequery[0]);
            indegrees[prerequery[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
                visited[i] = 1;
            }
        }

        int[] ans = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans[idx++] = cur;
            for (int next : graph[cur]) {
                if (visited[next] == 1) {
                    continue;
                }
                indegrees[next]--;
                if (indegrees[next]  == 0) {
                    visited[next] = 1;
                    queue.offer(next);
                }
            }
        }
        if (idx != numCourses) {
            return new int[0];
        }
        return ans;
    }

    private boolean dfs(List<Integer>[] graph, int[] visited, int cur, int parent) {
        visited[cur] = 1;
        for (int next : graph[cur]) {
            if (visited[next] == 1) {
                if (next != parent) {
                    return true;
                }
                continue;
            }
            if (dfs(graph, visited, next, cur)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test001() {
        int[][] prerequers = {
                {1, 0}
        };
        int[] res = findOrder(2, prerequers);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void test002() {
        int[][] prerequers = {{1,0},{2,0},{3,1},{3,2}};
        int[] res = findOrder(4, prerequers);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void test003() {
        int[][] prerequers = {{0,1},{0,2},{1,2}};
        int[] res = findOrder(3, prerequers);
        System.out.println(Arrays.toString(res));
    }


}
