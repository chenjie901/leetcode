package chenjie.leetcode;

import org.junit.Test;

/**
 * 1 cny = 2hkd
 * 1 usd = 8cny
 * 1gbp=2usd
 * <p>
 * 1 3 1 127 hdk max
 * <p>
 * 2 8 2 127 hdk max
 */
public class Currency {
    String[] types = {"hkd", "cny", "usd", "gbp"};
    int[][] values = new int[][]{{0, 1}, {0, 2}, {1, 8}, {2, 2}};

    @Test
    public void testCurrency() {

        currency(127, "max", 2);

    }

    @Test
    public void testExchange() {
        System.out.println(exchange(0, 3));
        System.out.println(exchange(2, 3));
        System.out.println(exchange(1, 3));
    }

    public int exchange(int source, int target) {
        int charge = 1;
        while (source != target) {
            charge = charge * values[target][1];
            target = values[target][0];
        }
        return charge;
    }

    public void currency(int remain, String type, int currencyTypeIndex) {
        int[] changes = new int[4];
        if (type.equals("max")) {
            for (int i = 3; i >= currencyTypeIndex; i--) {
                int exchange = exchange(currencyTypeIndex, i);
                changes[i] = remain / exchange;
                remain = remain % exchange;
            }
        } else {
            int exchange = exchange(0, currencyTypeIndex);
            changes[0] = remain * exchange;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 3; i >= 0; i--) {
            if (changes[i] != 0) {
                sb.append(changes[i] + " " + types[i] + " ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
