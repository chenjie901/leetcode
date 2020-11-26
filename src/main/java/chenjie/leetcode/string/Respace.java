package chenjie.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 面试题 17.13. 恢复空格
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * <p>
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 * <p>
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 */
public class Respace {
    public int respace(String[] dictionary, String sentence) {

        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[sentence.length() + 1];
        for (int i = 1; i <= sentence.length() + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (set.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[sentence.length()];
    }

    CharNode addWord(String word, CharNode root) {
        CharNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                CharNode node = new CharNode();
                cur.children[c - 'a'] = node;
                cur = node;
            } else {
                cur = cur.children[c - 'a'];
            }
        }
        cur.word = word;
        return root;
    }

    boolean findWord(CharNode root, String word) {
        CharNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            } else if (cur.word != null) {
                return true;
            } else {
                cur = cur.children[c - 'a'];
            }
        }

        if (cur.word != null) {
            return true;
        }

        return false;

    }

    @Test
    public void test1() {
        Respace respace = new Respace();
        CharNode root = new CharNode();
        respace.addWord("abc", root);
        respace.addWord("abd", root);
        boolean res = respace.findWord(root, "ab");
        Assert.assertTrue(res);
    }

    @Test
    public void test2() {
        Respace respace = new Respace();
        CharNode root = new CharNode();
        respace.addWord("abc", root);
        respace.addWord("abd", root);
        String[] dict = new String[]{"abc", "abd"};
        respace.respace(dict, "abcabd");

    }

    @Test
    public void test3() {
        Respace respace = new Respace();
        CharNode root = new CharNode();
        respace.addWord("abc", root);
        respace.addWord("abd", root);
        String[] dict = new String[]{"looked","just","like","her","brother"};
        respace.respace(dict, "jlooked");

    }
}

class CharNode {
    CharNode[] children = new CharNode[26];
    String word = null;

    public CharNode() {
    }
}
