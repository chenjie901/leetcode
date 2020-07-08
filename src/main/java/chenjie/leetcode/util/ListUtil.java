package chenjie.leetcode.util;

import chenjie.leetcode.ListNode;

public class ListUtil {

    public static ListNode createList(int... ele) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int e : ele) {
            cur.next = new ListNode(e);
            cur = cur.next;
        }
        return head.next;
    }

    public static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.printf("%d ", listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }

}
