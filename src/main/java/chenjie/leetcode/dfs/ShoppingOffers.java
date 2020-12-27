package chenjie.leetcode.dfs;

import java.util.Arrays;
import java.util.List;

public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int[] needs1 = needs.stream().mapToInt(need -> need.intValue()).toArray();
        return backtrace(price, special, needs1, 0);
    }

    public int backtrace(List<Integer> price, List<List<Integer>> special, int[] needs, int cost) {
        if (Arrays.stream(needs).allMatch(need -> need == 0)) {
            return cost;
        }

        int minCost = cost;
        for (int i = 0; i < needs.length; i++) {
            minCost += price.get(i) * needs[i];
        }

        for (int i = 0; i < special.size(); i++) {
            List<Integer> items = special.get(i);
            if (!canChoose(needs, items)) {
                continue;
            }

            for (int j = 0; j < needs.length; j++) {
                needs[j] -= items.get(j);
            }

            minCost = Math.min(minCost, backtrace(price, special, needs, cost + items.get(needs.length)));

            for (int j = 0; j < needs.length; j++) {
                needs[j] += items.get(j);
            }
        }

        return minCost;
    }

    private boolean canChoose(int[] needs, List<Integer> choice) {
        for (int i = 0; i < needs.length; i++) {
            if (needs[i] - choice.get(i) < 0) {
                return false;
            }
        }
        return true;
    }
}
