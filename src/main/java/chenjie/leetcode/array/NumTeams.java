package chenjie.leetcode.array;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class NumTeams {
    int ans = 0;
    public int numTeams(int[] rating) {
        List<Integer> path1 = new LinkedList<>();
        backtrace(rating, 0, path1);

        return ans;
    }

    public void backtrace(int[] rating, int idx, List<Integer> path) {

        if (path.size() == 3) {

            if (rating[path.get(0)] > rating[path.get(1)] && rating[path.get(1)] > rating[path.get(2)]) {
                System.out.printf("%d %d %d\n", rating[path.get(0)],rating[path.get(1)], rating[path.get(2)]);
                ans++;
            }

            if (rating[path.get(0)] < rating[path.get(1)] && rating[path.get(1)] < rating[path.get(2)]) {
                System.out.printf("%d %d %d\n", rating[path.get(0)],rating[path.get(1)], rating[path.get(2)]);

                ans++;
            }
            return;
        }

        if ( idx >= rating.length) {
            return;
        }

        for (int i = idx; i < rating.length; i++) {
            path.add(i);
            backtrace(rating, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public void backtrace1(int[] rating, int idx, List<Integer> path) {
        if (path.size() == 3) {
            if (rating[path.get(0)] > rating[path.get(1)] && rating[path.get(1)] > rating[path.get(2)]) {
                System.out.printf("%d %d %d\n", rating[path.get(0)],rating[path.get(1)], rating[path.get(2)]);

                ans++;
            }

            if (rating[path.get(0)] < rating[path.get(1)] && rating[path.get(1)] < rating[path.get(2)]) {
                System.out.printf("%d %d %d\n", rating[path.get(0)],rating[path.get(1)], rating[path.get(2)]);

                ans++;
            }
            return;
        }

        if (path.size() > 3 || idx < 0) {
            return;
        }
        for (int i = idx; i >= 0; i--) {
            path.add(i);
            backtrace1(rating, i - 1, path);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test001() {
        int[] arr = {2, 5, 3, 4, 1};
        System.out.println(numTeams(arr));
    }

    @Test
    public void test002() {
        int[] arr = {1, 2, 3,4};
        System.out.println(numTeams(arr));
    }
}
