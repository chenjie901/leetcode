package chenjie.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit {
    public int totalFruit(int[] tree) {
        return atMostK(tree, 2);
    }

    private int atMostK(int[] tree, int nums) {
        Map<Integer, Integer> fruitCount = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        int cnt = 0;
        while (right < tree.length) {
            fruitCount.put(tree[right], fruitCount.getOrDefault(tree[right], 0) + 1);
            if (fruitCount.get(tree[right]) == 1) {
                cnt++;
            }
            right++;

            while (cnt > nums) {
                if (fruitCount.get(tree[left]) - 1 == 0) {
                    cnt--;
                }
                fruitCount.put(tree[left], fruitCount.get(tree[left]) - 1);
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    @Test
    public void test001() {
        int[] arr = {1, 2, 1};
        assertEquals(3, totalFruit(arr));
    }

    @Test
    public void test002() {
        int[] arr = {0, 1, 2, 2};
        assertEquals(3, totalFruit(arr));
    }

    @Test
    public void test003() {
        int[] arr = {1, 2, 3, 2, 2};
        assertEquals(4, totalFruit(arr));
    }


}
