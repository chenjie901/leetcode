package chenjie.leetcode.doublepointer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//763. 划分字母区间
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        int pre = -1;
        int p1 = 0;
        List<Integer> ans = new ArrayList<>();
        int p2 = 0;
        for (; p2 < S.length() && p1 < S.length(); ) {
            p2 = Math.max(map.get(S.charAt(p1)), p2);
            if (p1 == p2) {
                ans.add(p1 - pre);
                pre = p1;
                p2++;
            }
            p1++;
        }
        if (pre + 1 < S.length() - 1) {
            ans.add(S.length() - (pre + 1));
        }
        return ans;
    }

    @Test
    public void test001() {
        System.out.println(partitionLabels("caedbdedda"));
    }
}
