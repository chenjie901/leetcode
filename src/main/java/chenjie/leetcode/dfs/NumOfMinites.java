package chenjie.leetcode.dfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumOfMinites {

    private List<Integer>[] adj;
    private int res;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            int m = manager[i];
            if (-1 == m) {
                continue;
            }
            if (adj[m] == null) {
                adj[m] = new LinkedList<>();
            }
            adj[m].add(i);
        }
         dfs(headID, informTime[headID], informTime);
        return res;
    }
    public void dfs(int idx, int sum, int[] informTime) {
        if (adj[idx] == null) {
            res = Math.max(res, sum);
            return;
        }

        for (Integer id : adj[idx]) {
            dfs(id, sum + informTime[id], informTime);
        }
    }

    @Test
    public void test001() {
        int[] manager = new int[]{3,3,-1,2};
        int[] informTime = new int[]{0,0,162,914};
        int cost = numOfMinutes(4, 2, manager, informTime);
        System.out.println(cost);
    }
    @Test
    public void test002() {
        int[] manager = new int[]{2,2,-1,2,2,2};
        int[] informTime = new int[]{0,0,1,0,0,0};
        int cost = numOfMinutes(6, 2, manager, informTime);
        System.out.println(cost);
    }





    @Test
    public void test005() {
        int[] manager = new int[]{5,9,6,10,-1,8,9,1,9,3,4};
        int[] informTime = new int[]{0,213,0,253,686,170,975,0,261,309,337};
        int cost = numOfMinutes(11, 4, manager, informTime);
        System.out.println(cost);
    }



}
