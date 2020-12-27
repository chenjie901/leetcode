package chenjie.leetcode.bfs;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class KthGrammar {
    public int kthGrammar(int N, int K) {
        Deque<Integer> res = new LinkedList<>();
        res.add(0);
        for (int i = 2; i <= N; i++) {
            kthGrammar(res);
//            System.out.printf("line:%d, %s\n", i , res);
        }

        while (K > 1) {
            res.pollFirst();
            K--;
        }
        return res.pollFirst();
    }

    public void kthGrammar(Deque<Integer> pre) {
        int size = pre.size();
        for (int i = 0; i < size; i++) {
            int p = pre.pollFirst();
            if (p == 1) {
                pre.addLast(1);
                pre.addLast(0);
            } else {
                pre.addLast(0);
                pre.addLast(1);
            }
        }
    }

    @Test
    public void test001() {
        System.out.println(kthGrammar(30, 434991989));
    }
}
