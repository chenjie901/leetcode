package chenjie.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
        curr.count += 1;
    }

    public boolean exist(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr != null && curr.word != null;
    }

    public List<String> searchPrefix(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                continue;
            }
            curr = curr.children[c - 'a'];
        }
        return dfs(curr);
    }

    public List<String> searchSubSet(String word) {
        return searchSubSet(root, word, 0);
    }


    public List<String> searchSubSet(TrieNode curNode, String word, int idx) {
        List<String> ans = new LinkedList<>();
        if (curNode.word != null) {
            ans.add(curNode.word);
        }

        for (int i = idx; i < 26; i++) {
            if (curNode.children[i] != null && word.indexOf((char)(i + 'a')) != -1) {
                ans.addAll(searchSubSet(curNode.children[i], word, i + 1));
            }
        }
        return ans;
    }

    public List<String> dfs() {
        return dfs(root);
    }

    public List<String> dfs(TrieNode root) {
        List<String> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        if (root.word != null) {
            ans.add(root.word);
        }
        for (int i = 0; i < 26; i++) {
            ans.addAll(dfs(root.children[i]));
        }
        return ans;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
        int count = 0;
    }
}
