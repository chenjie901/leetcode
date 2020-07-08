package chenjie.leetcode.divideandconquer;

import chenjie.leetcode.ListNode;
import chenjie.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MergeKList {

    @Test
    public void testMerge2List() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(5);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(8);

        ListNode l = mergeTwoList(l1, l2);

        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    @Test
    public void mergeKList() {
        ListNode l1 = ListUtil.createList(2, 3, 4);
        ListNode l2 = ListUtil.createList(1, 3, 5);
        ListNode l3 = ListUtil.createList(2, 6, 9);
        ListNode l4 = ListUtil.createList(10, 11, 12);
        ListNode[] list = {l1, l2, l3, l4};
        ListNode l = mergeKLists(list);
        System.out.println("---->");
        ListUtil.printList(l);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;

        if (len == 0) {
            return null;
        }

        while (len > 1) {
            int i = 0;
            for (; i < len / 2; i++) {
                lists[i] = mergeTwoList(lists[2 * i], lists[2 * i + 1]);
//                ListUtil.printList(lists[i]);
            }
            if (len % 2 != 0) {
                lists[i] = lists[len - 1];
//                ListUtil.printList(lists[i]);
                len++;
            }

            len = len / 2;
        }

        return lists[0];


    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                prev.next = l2;
                return head.next;
            }

            if (l2 == null) {
                prev.next = l1;
                return head.next;
            }

            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }
        return head.next;
    }

    @Test
    public void testPartition() {
        int[] nums = {3,2,3,1,2,4,5,5,6};
//        partition(nums, 0, nums.length - 1);

//        System.out.println(Arrays.toString(nums));
        System.out.println(findKthLargest(nums, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, nums.length - k, 0, nums.length - 1);
    }

    public int findKthLargest(int[] nums, int k, int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int pivot = partition(nums, low, high);
//        System.out.println(Arrays.toString(nums));
        if (k == pivot) {
            return nums[pivot];
        }

        if (k < pivot) {
            return findKthLargest(nums, k, low, pivot - 1);
        } else {
            return findKthLargest(nums, k, pivot + 1, high);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int partition(int[] nums, int low, int high) {
        int pivot = low;
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] < nums[pivot]) {
                j++;
                swap(nums, i, j);
            }
        }

        pivot = j;
        swap(nums, pivot, low);
        return pivot;
    }
}
