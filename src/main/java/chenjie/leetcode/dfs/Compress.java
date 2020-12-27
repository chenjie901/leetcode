package chenjie.leetcode.dfs;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Compress {
    public int compress(char[] chars) {
        Deque<Character> characters = new LinkedList<>();
        Deque<Integer> cnt = new LinkedList<>();
        compress(chars, 0, characters, cnt);
        int i = 0;
        while (!characters.isEmpty()) {
            char last = characters.pollFirst();
            int lastCnt = cnt.pollFirst();
            chars[i++] = last;
            if (lastCnt > 1) {
                String tmp = String.valueOf(lastCnt);
                for (int j = 0; j < tmp.length(); j++) {
                    chars[i++] = tmp.charAt(j);
                }
            }
        }
        return i;
    }

    public void compress(char[] chars, int idx, Deque<Character> characters, Deque<Integer> cnt) {
        if (idx >= chars.length) {
            return;
        }

        if (!characters.isEmpty() && chars[idx] == characters.peekLast()){
            int last = cnt.pollLast();
            last++;
            cnt.addLast(last);
        } else {
            characters.addLast(chars[idx]);
            cnt.addLast(1);
        }
        compress(chars, idx + 1, characters, cnt);
    }

    @Test
    public void test001() {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c'};
        int cnt = compress(chars);
        System.out.println(cnt);
        System.out.println(Arrays.toString(chars));
    }

    @Test
    public void test002() {
        char[] chars = {'a'};
        int cnt = compress(chars);
        System.out.println(cnt);
        System.out.println(Arrays.toString(chars));
    }
}
