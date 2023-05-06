package chenjie.leetcode.daily;

import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> ans = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, new LinkedList<>());
        return ans;
    }

    private void dfs(String s, int idx, List<String> path) {
        if (idx >= s.length() ) {
            if(path.size() == 4) {
                ans.add(String.join(".", path));
            }
            return;
        }
        //25525511135
        for (int i = idx; i < idx + 3 ; i++) {
            System.out.printf("idx:%d\n", idx);
            if (i +1 > s.length()) {
                continue;
            }

            String seg = s.substring(idx, i + 1);
            if (valid(seg)) {
                path.add(seg);
                dfs(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean valid(String seg) {
        if (seg.length() > 1 && seg.charAt(0) == '0') {
            return false;
        }

        int num = Integer.parseInt(seg);
        if (num < 0 || num > 255) {
            return false;
        }
        return true;
    }
}
