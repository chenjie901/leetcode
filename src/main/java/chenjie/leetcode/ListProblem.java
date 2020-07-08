package chenjie.leetcode;


public class ListProblem {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        int carry = 0;
        ListNode cur = pre;
        while(l1 != null || l2 != null) {

            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            while(l1 != null) {
                l1 = l1.next;
            }
            while (l2 != null) {
                l2 = l2.next;
            }

            if (carry == 1) {
                cur.next = new ListNode(carry);
            }
        }
        return  pre.next;
    }

}
