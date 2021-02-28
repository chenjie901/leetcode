package chenjie.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SuggestedProducts {
    TrieNode root = new TrieNode();
    String[] products;
    List<List<String>> ans = new LinkedList<>();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        this.products = products;
        for (int i = 0; i < products.length; i++) {
            insert(products[i], i);
        }

        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            ans.add(new LinkedList<>(getWordsStartingWith(prefix)));
        }
        return ans;
    }

    List<String> getWordsStartingWith(String prefix) {
        TrieNode cur = root;
        List<String> buffer = new ArrayList<>();
        for (char c : prefix.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                return buffer;
            }
            cur = cur.child[c - 'a'];
        }
        dfs(cur, buffer);
        return buffer;
    }

    void insert(String word, Integer wordIdx) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.child[idx] == null) {
                cur.child[idx] = new TrieNode();
            }
            cur.isEnd = false;
            cur = cur.child[idx];
        }
        cur.wordIdx = wordIdx;
        cur.isEnd = true;
        cur.count++;
    }

    void dfs(TrieNode root, List<String> path) {
        if (root.isEnd) {
            for (int i = 0; i < 3; i++) {
                path.add(products[root.wordIdx]);
                if (path.size() == 3) {
                    return;
                }
            }
            return;
        }

        if (root.wordIdx != null) {
            path.add(products[root.wordIdx]);
        }

        if (path.size() >= 3) {
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                dfs(root.child[i], path);
            }
        }
    }


    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
        Integer wordIdx;
        int count;

        public TrieNode() {
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
            isEnd = false;
            wordIdx = null;
        }
    }
}
