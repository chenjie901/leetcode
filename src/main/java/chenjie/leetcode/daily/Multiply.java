package chenjie.leetcode.daily;

import java.util.Arrays;

public class Multiply {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] ans = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + ans[p2];
                ans[p2] = sum % 10;
                ans[p1] += sum / 10;
            }
        }

        int i = 0;
        for (; i < ans.length; i++) {
            if (ans[i] != 0) {
                break;
            }
        }

        //System.out.println(Arrays.toString(ans));

        StringBuffer sb = new StringBuffer();
        for (; i < ans.length; i++) {
            sb.append(ans[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
