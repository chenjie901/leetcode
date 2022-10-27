package chenjie.leetcode.daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{startTime[i], endTime[i], profit[i]});
        }

        Collections.sort(list, (a, b) -> a[1] - b[1]);

        int[] f = new int[n + 10];
        for (int i = 1; i <=n; i++) {
            int[] info = list.get(i - 1);
            int s = info[0];
            int e = info[1];
            int p = info[2];
            f[i] = Math.max(p, f[i - 1]);
            int l = 0;
            int r = i - 1;
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (list.get(mid)[1] <= s) {
                     l = mid;
                } else {
                    r  = mid - 1;
                }
            }
            if (list.get(l)[1] <= s) {
                f[i] = Math.max(f[i], f[l + 1] + p);
            }
        }
        return f[n];
    }
}
