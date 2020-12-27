package chenjie.leetcode.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDistinct {
    public int subarraysWithKDistinct1(int[] A, int K) {
        int p1 = 0;
        int p2 = 0;
        int res = 0;
        Map<Integer, Integer> w1 = new HashMap<>();
        Map<Integer, Integer> w2 = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            while (p1 < A.length && w1.size() < K) {
                w1.put(A[p1], w1.getOrDefault(A[p1], 0) + 1);
                p1++;
            }

            while (p2 < A.length && w2.size() <= K) {
                w2.put(A[p2], w1.getOrDefault(A[p2], 0) + 1);
                p2++;
            }
            p2--;

            System.out.printf("%d %d %d\n", i, p1, p2);
            if (p2 > p1 - 1) {
                res = res + (p2 - p1 - 1);
            }

            shrinkWindows(w1, A[i]);
            shrinkWindows(w2, A[i]);
        }
        return res;
    }

    public void shrinkWindows(Map<Integer, Integer> w, int key) {
        if (!w.containsKey(key)) {
            return;
        }

        int v = w.get(key);
        v--;
        if (v <= 0) {
            w.remove(key);
        } else {
            w.put(key, v);
        }
    }

    @Test
    public void test001() {
        int[] arr = {1, 2, 1, 2, 3};
        System.out.println(subarraysWithKDistinct(arr, 2));
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        Window window1 = new Window();
        Window window2 = new Window();
        int ans = 0, left1 = 0, left2 = 0;

        for (int right = 0; right < A.length; ++right) {
            int x = A[right];
            window1.add(x);
            window2.add(x);

            while (window1.different() > K)
                window1.remove(A[left1++]);
            while (window2.different() >= K)
                window2.remove(A[left2++]);
            System.out.printf("%d %d %d\n", right, left1, left2);

            ans += left2 - left1;
        }

        return ans;
    }
}

class Window {
    Map<Integer, Integer> count;
    int nonzero;

    Window() {
        count = new HashMap();
        nonzero = 0;
    }

    void add(int x) {
        count.put(x, count.getOrDefault(x, 0) + 1);
        if (count.get(x) == 1)
            nonzero++;
    }

    void remove(int x) {
        count.put(x, count.get(x) - 1);
        if (count.get(x) == 0)
            nonzero--;
    }

    int different() {
        return nonzero;
    }




}
