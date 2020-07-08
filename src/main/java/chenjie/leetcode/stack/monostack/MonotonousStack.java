package chenjie.leetcode.stack.monostack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class MonotonousStack {

    @Test
    public void testSmallestSubsequence() {
        Assert.assertEquals("abc", smallestSubsequence("adbcc"));
    }
    /**
     * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
     * 示例 1：
     * 输入："cdadabcc"
     * 输出："adbc"
     * 示例 2：
     *
     * 输入："abcd"
     * 输出："abcd"
     * 示例 3：
     *
     * 输入："ecbacba"
     * 输出："eacb"
     * 示例 4：
     *
     * 输入："leetcode"
     * 输出："letcod"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    public String smallestSubsequence(String text) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            if (stack.contains(c)) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && text.indexOf(stack.peek(), i) != -1 ) {
                stack.pop();
            }
            stack.push(c);
        }

        StringBuffer sb = new StringBuffer();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
