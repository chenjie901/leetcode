package chenjie.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinRemoveTomakeValid {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stack.push(i);
            } else if (')' == s.charAt(i)){
                if (stack.isEmpty()) {
                    indexToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            indexToRemove.add(stack.pop());
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (!indexToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    @Test
    public void test1() {
        MinRemoveTomakeValid minRemoveTomakeValid = new MinRemoveTomakeValid();
        String s = "a(b";
        String res = minRemoveTomakeValid.minRemoveToMakeValid(s);
        Assert.assertEquals("ab", res);
    }

    @Test
    public void test2() {
        MinRemoveTomakeValid minRemoveTomakeValid = new MinRemoveTomakeValid();
        String s = "a)b";
        String res = minRemoveTomakeValid.minRemoveToMakeValid(s);
        Assert.assertEquals("ab", res);
    }

    @Test
    public void test3() {
        MinRemoveTomakeValid minRemoveTomakeValid = new MinRemoveTomakeValid();
        String s = "a()b";
        String res = minRemoveTomakeValid.minRemoveToMakeValid(s);
        Assert.assertEquals("a()b", res);
    }

    @Test
    public void test4() {
        MinRemoveTomakeValid minRemoveTomakeValid = new MinRemoveTomakeValid();
        String s = "a()(b";
        String res = minRemoveTomakeValid.minRemoveToMakeValid(s);
        Assert.assertEquals("a()b", res);
    }

    @Test
    public void test5() {
        MinRemoveTomakeValid minRemoveTomakeValid = new MinRemoveTomakeValid();
        String s = "lee(t(c)o)de)";
        String res = minRemoveTomakeValid.minRemoveToMakeValid(s);
        Assert.assertEquals("lee(t(c)o)de", res);
    }
}
