package chenjie.leetcode.daily;

public class KthGrammar {
    public int kthGrammar(int n, int k) {
        // 0
        // 01
        // 0110
        // 01101001
        // 0110100110010110

        if (n == 1) {
            return 0;
        }

        int v = kthGrammar(n - 1, (k + 1) / 2);
        int odd = k % 2;
        if (v == 1) {
            if (odd == 0) {
                return 0;
            }
            return 1;
        }

        if (odd == 0) {
            return 1;
        }
        return 0;

    }
}
