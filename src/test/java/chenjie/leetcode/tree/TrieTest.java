package chenjie.leetcode.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TrieTest {
    Trie trie = new Trie();

    @Before
    public void init() {
        trie.insert("abc");
        trie.insert("ack");
        trie.insert("akc");
        trie.insert("abcd");
        trie.insert("abcm");
        trie.insert("ab");
    }

    @Test
    public void test01() {
        Assert.assertTrue(trie.exist("abcd"));
        Assert.assertFalse(trie.exist("acke"));
    }

    @Test
    public void test02() {
        List<String> ans = trie.searchPrefix("ab");
        System.out.println(ans);
    }

    @Test
    public void test03() {
        List<String> ans = trie.dfs();
        System.out.println(ans);
    }

    @Test
    public void test04() {
        List<String> ans = trie.searchSubSet("abcdefk");
        System.out.println(ans);
    }

}