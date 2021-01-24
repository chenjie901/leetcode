package chenjie.leetcode.graph;

import org.junit.Test;

import java.util.*;

public class SortItems {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<Integer>[] itemsAdj = new List[n];
        int[] itemsIndegree = new int[n];
        for (int i = 0; i < itemsAdj.length; i++) {
            itemsAdj[i] = new LinkedList<>();
        }

        for (int i = 0; i < beforeItems.size(); i++) {
            List<Integer> preRequery = beforeItems.get(i);
            for (int before : preRequery) {
                itemsAdj[before].add(i);
                itemsIndegree[i]++;
            }
        }

        List<Integer> items = topoSort(itemsAdj, itemsIndegree);
        if(items.size() == 0) {
            return new int[0];
        }
        //任务i没有被安排任务，初始化一个不存在的组
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        System.out.println(items);
        //每个item分到哪个组，组内拓扑排序结果存下来
        Map<Integer, List<Integer>> group2Items = new HashMap<>();
        for (int item : items) {
            group2Items.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        List<Integer>[] groupsAdj = new List[m];
        int[] groupsIndegree = new int[m];
        for (int i = 0; i < groupsAdj.length; i++) {
            groupsAdj[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            int currentGroup = group[i];
            //完成第i个任务，需要先完成第i个任务之前的所有组
            for (int beforeItem : beforeItems.get(i)) {
                if (currentGroup != group[beforeItem]) {
                    groupsAdj[group[beforeItem]].add(currentGroup);
                    groupsIndegree[currentGroup]++;
                }
            }
        }

        List<Integer> ans = new LinkedList<>();
        List<Integer> groups = topoSort(groupsAdj, groupsIndegree);
        if (groups.size() == 0) {
            return new int[0];
        }
        for (int groupId : groups) {
            List<Integer> sortedItems = group2Items.getOrDefault(groupId, new ArrayList<>());
            ans.addAll(sortedItems);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();

    }

    private List<Integer> topoSort(List<Integer>[] graph, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[graph.length];
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                visited[i] = 1;
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans.add(cur);
            for (int v : graph[cur]) {
                if (visited[v] == 1) {
                    continue;
                }
                indegree[v]--;
                if (indegree[v] == 0) {
                    visited[v] = 1;
                    queue.offer(v);
                }
            }
        }

        if (ans.size() != graph.length) {
            return new ArrayList<>();
        }

        return ans;
    }

    @Test
    public void test001() {
        List<List<Integer>> beforeItems = new LinkedList<>();
        beforeItems.add(Arrays.asList());
        beforeItems.add(Arrays.asList(6));
        beforeItems.add(Arrays.asList(5));
        beforeItems.add(Arrays.asList(6));
        beforeItems.add(Arrays.asList(3, 6));
        beforeItems.add(Arrays.asList());
        beforeItems.add(Arrays.asList());
        beforeItems.add(Arrays.asList());

        int[] group = {-1,-1,1,0,0,1,0,-1};

        sortItems(8, 2, group, beforeItems);

    }

    @Test
    public void test002() {
        List<List<Integer>> beforeItems = new LinkedList<>();
        beforeItems.add(Arrays.asList());
        beforeItems.add(Arrays.asList(0));
        beforeItems.add(Arrays.asList(1, 3));
        beforeItems.add(Arrays.asList(2));

        int[] group = {-1,0,0,-1};

        sortItems(4, 1, group, beforeItems);

    }
}
