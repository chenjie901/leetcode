package chenjie.leetcode.backtrack;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class letterCombinations {

    Map<String, String> map = new HashMap<>();

    @Test
    public void testLetterCombinations() {
        List<String> res = letterCombinations("");
        res.stream().forEach(s -> System.out.println(s));
    }

    public List<String> letterCombinations(String digits) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        List<String> res = new LinkedList<>();
        letterCombinations(digits, "", 0, res);
        return res;
    }

    public void letterCombinations(String digits, String cur, int index, List<String> res) {
        if (digits.isEmpty()) {
            return;
        }

        if (index <= digits.length()) { //可能解
            if (index == digits.length() && !cur.isEmpty()) {  //找到解
                res.add(cur);
            } else {
                String d = digits.substring(index, index + 1);
                for (char c : map.get(d).toCharArray()) {
                    letterCombinations(digits, cur + c, index + 1, res);
                }
            }
        }
    }

    public void letterCombinations1(String digits, String cur, int index, List<String> res) {
        if (digits.isEmpty()) { //输入判读
            return;
        }

        String d = digits.substring(index, index + 1);
        for (char c : map.get(d).toCharArray()) {
            if (index + 1 == digits.length() ) {  //找到解
                res.add(cur + c);
            } else {
                letterCombinations(digits, cur + c, index + 1, res);
            }

        }




    }
}
