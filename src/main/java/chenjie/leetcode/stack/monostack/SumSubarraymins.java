package chenjie.leetcode.stack.monostack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SumSubarraymins {
    private static final long MOD=(long)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            left[i] = st.peek();
            st.push(i);
        }
        int[] right = new int[n];
        st.clear();
        st.push(n);
        for (int i = n - 1; i >=0; i--) {
            while (st.size() > 1 && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            right[i] = st.peek();
            st.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long)arr[i] * (i - left[i]) *(right[i] - i);
        }
        return (int)(ans %MOD);
    }
}
