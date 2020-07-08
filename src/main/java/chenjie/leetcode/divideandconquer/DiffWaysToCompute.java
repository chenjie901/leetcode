package chenjie.leetcode.divideandconquer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {

    @Test
    public void testDiffWaysToCompute() {
        String input = "2*3-4*5";
        System.out.println(diffWaysToCompute(input));
    }
    public List<Integer> diffWaysToCompute(String input) {
        return partition(input);
    }

    public List<Integer> partition(String input) {
        List<Integer> result = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.valueOf(input));
            return result;
        }
//        int i = 1;
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                for(Integer left : partition(input.substring(0, i))) {
                    for (Integer right : partition(input.substring(i + 1))) {
                        if (input.charAt(i) == '+') {
                            result.add(left + right);
                        } else if (input.charAt(i) == '-') {
                            result.add(left - right);
                        } else if (input.charAt(i) == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        return result;
    }

}
