package chenjie.leetcode.bfs;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 126. 单词接龙 II
 * 难度
 * 困难
 *
 * 376
 *
 *
 *
 *
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换后得到的单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: []
 *
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */
public class FindLadders {
    Map<String, Integer> wordToNum = new HashMap<>();
    Map<Integer, String> numToWord = new HashMap<>();
    List<List<String>> ans = new LinkedList<>();
    Map<Integer, List<Integer>> successors = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        if (!wordList.contains(endWord)) {
            return ans;
        }

        Map<Integer, List<Integer>> graph = buildGraph(wordList);
        printGraph(graph);

        if (!bfs(graph, indexOf(beginWord), indexOf(endWord))) {
            return ans;
        }

        printSuccessors();
        Set<Integer> visited = new HashSet<>();
        visited.add(indexOf(beginWord));
        List<String> path = new LinkedList<>();
        path.add(beginWord);
        backtrace(successors, indexOf(beginWord), indexOf(endWord), visited, path);
        return ans;
    }

    private void backtrace(Map<Integer, List<Integer>> graph, int cur, int end, Set<Integer> visited, List<String> path) {
        if (cur == end) {
            ans.add(new LinkedList<>(path));
            return;
        }
        if (!graph.containsKey(cur)) {
            return;
        }
        List<Integer> adj = graph.get(cur);
        for (int i = 0; i < adj.size(); i++) {
            int next = adj.get(i);
            path.add(numToWord.get(next));
            visited.add(next);
            backtrace(graph, next, end, visited, path);
            visited.remove(next);
            path.remove(path.size() - 1);
        }
    }

    void printSuccessors() {
        for (Map.Entry<Integer, List<Integer>> successor : successors.entrySet()) {
            System.out.printf("%s(%d)-->", numToWord.get(successor.getKey()), successor.getKey());
            for (int n : successor.getValue()) {
                System.out.printf("%s(%d) ", numToWord.get(n), n);
            }
            System.out.println();
        }
    }


    private boolean bfs(Map<Integer, List<Integer>> graph, int start, int end) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, null));
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        boolean found = false;
        Set<Integer> nextLevelVisited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                for (int adj : graph.get(cur.idx)) {
                    if (visited.contains(adj)) {
                        continue;
                    }
                    if (adj == end) {
                        found = true;
                    }
                    if (!nextLevelVisited.contains(adj)) {
                        nextLevelVisited.add(adj);
                        queue.offer(new Node(adj, cur));
                    }
                    successors.putIfAbsent(cur.idx, new LinkedList<>());
                    successors.get(cur.idx).add(adj);
                }
//                System.out.println();
            }
            if (found == true) {
                return true;
            }
            visited.addAll(nextLevelVisited);
            nextLevelVisited.clear();
        }
        return false;
    }

    private void printGraph(Map<Integer, List<Integer>> graph) {
        for (Integer v : graph.keySet()) {
            System.out.printf("%s(%d)-->", numToWord.get(v), v);
            for (Integer c : graph.get(v)) {
                System.out.printf("%s(%d) ", numToWord.get(c), c);
            }
            System.out.println();
        }
    }


    Map<Integer, List<Integer>> buildGraph(List<String> wordList) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word1 = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String word2 = wordList.get(j);
                int word1Id = indexOf(word1);
                int word2Id = indexOf(word2);
                graph.putIfAbsent(word1Id, new LinkedList<>());
                graph.putIfAbsent(word2Id, new LinkedList<>());

                if (!canTrans(word1, word2)) {
                    continue;
                }

                List<Integer> adjWord1 = graph.get(word1Id);
                adjWord1.add(word2Id);
                graph.put(word1Id, adjWord1);
                List<Integer> adjWord2 = graph.get(word2Id);
                adjWord2.add(word1Id);
                graph.put(word2Id, adjWord2);
            }
        }
        return graph;
    }

    private boolean canTrans(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] chars1 = word1.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char pre = chars1[i];
                if (pre == c) {
                    continue;
                }
                chars1[i] = c;
                if (word2.equals(new String(chars1))) {
                    return true;
                }
                chars1[i] = pre;
            }
        }
        return false;
    }

    class Node {
        int idx;
        Node prev;

        public Node(int idx, Node prev) {
            this.idx = idx;
            this.prev = prev;
        }
    }

    //单词转index
    private int indexOf(String word) {
        if (wordToNum.containsKey(word)) {
            return wordToNum.get(word);
        }
        wordToNum.put(word, wordToNum.size());
        int idx = wordToNum.get(word);
        numToWord.put(idx, word);
        return idx;
    }


    @Test
    public void testCanTrans() {
        List<List<String>> ans = findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog").stream().collect(Collectors.toList()));
        System.out.println("----------");
        for (List<String> a : ans) {
            System.out.println(a);
        }
    }

    @Test
    public void testCanTrans1() {
        List<List<String>> ans = findLadders("a", "c", Arrays.asList("a", "b", "c").stream().collect(Collectors.toList()));
        System.out.println("----------");
        for (List<String> a : ans) {
            System.out.println(a);
        }
    }

    @Test
    public void testCanTrans2() {
        List<List<String>> ans = findLadders("red", "tax", Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee").stream().collect(Collectors.toList()));
        System.out.println("----------");
        for (List<String> a : ans) {
            System.out.println(a);
        }
    }

}
