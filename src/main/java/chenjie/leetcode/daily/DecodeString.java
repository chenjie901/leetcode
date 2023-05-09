package chenjie.leetcode.daily;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
    public String decodeString(String s) {
        StringBuffer res = new StringBuffer();
        int multi = 0;
        Deque<Integer> multiStack = new LinkedList<>();
        Deque<String> resStack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                multiStack.offerLast(multi);
                resStack.offerLast(res.toString());
                multi = 0;
                res.setLength(0);
            } else if (c == ']') {
                StringBuffer tmp = new StringBuffer();
                int curMulti = multiStack.pollLast();
                for (int i = 0; i < curMulti; i++) {
                    tmp.append(res);
                }
                res = new StringBuffer(resStack.pollLast() +tmp.toString() );
            } else if (Character.isDigit(c)) {
                multi = multi *10 + c - '0';
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
