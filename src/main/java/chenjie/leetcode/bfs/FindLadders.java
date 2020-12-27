package chenjie.leetcode.bfs;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class FindLadders {
    Map<String, Integer> wordToNum = new HashMap<>();
    Map<Integer, String> numToWord = new HashMap<>();
    int cnt = 0;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new LinkedList<>();
        wordList.add(beginWord);
        if (!wordList.contains(endWord)) {
            return ans;
        }
        Map<Integer, List<Integer>> graph = buildGraph(wordList);
        printGraph(graph);
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(getNum(beginWord), null));
        Set<Integer> visited = new HashSet<>();
        visited.add(getNum(beginWord));
        int shortest = Integer.MAX_VALUE;
        int target = getNum(endWord);
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point c = queue.poll();
                if (c.cur == target) {
//                    if (dist > shortest) {
//                        continue;
//                    }
//                    shortest = dist;
                    List<String> path = new LinkedList<>();
                    while (c != null) {
                        path.add(c.word);
                        c = c.pre;
                    }
                    Collections.reverse(path);
                    ans.add(new LinkedList<>(path));
                    continue;
                }
                for (int adj : graph.get(c.cur)) {
                    if (visited.contains(adj)) {
                        continue;
                    }
                    Point p = new Point(adj, c);
                    visited.add(p.cur);
                    queue.offer(p);
                }
            }
            dist++;
        }
        return ans;
    }

    private void printGraph(Map<Integer, List<Integer>> graph) {
        for (Integer v : graph.keySet()) {
            System.out.printf("%s-->", numToWord.get(v));
            for (Integer c : graph.get(v)) {
                System.out.printf("%s ", numToWord.get(c));
            }
            System.out.println();
        }
    }

    class Point {
        int cur;
        Point pre;
        String word;

        public Point(int cur, Point pre) {
            this.cur = cur;
            this.pre = pre;
            word = numToWord.get(cur);
        }
    }

    Map<Integer, List<Integer>> buildGraph(List<String> wordList) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word1 = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String word2 = wordList.get(j);
                if (!canTrans(word1, word2)) {
                    continue;
                }
                int word1Id = getNum(word1);
                int word2Id = getNum(word2);
                List<Integer> adjWord1 = graph.getOrDefault(word1Id, new LinkedList<>());

                adjWord1.add(word2Id);
                graph.put(word1Id, adjWord1);
                List<Integer> adjWord2 = graph.getOrDefault(word2Id, new LinkedList<>());
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

    private int getNum(String word) {
        if (wordToNum.containsKey(word)) {
            return wordToNum.get(word);
        }
        int temp = cnt;
        wordToNum.put(word, cnt);
        numToWord.put(cnt, word);
        ++cnt;
        return temp;
    }

    @Test
    public void testCanTrans() {
        List<List<String>> ans = findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog").stream().collect(Collectors.toList()));
        System.out.println("----------");
        for (List<String> a : ans) {
            System.out.println(a);
        }
    }

}
