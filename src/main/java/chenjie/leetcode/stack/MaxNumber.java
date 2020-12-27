package chenjie.leetcode.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaxNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = null;
        for (int i = 0; i <= k; i++) {
            if (nums1.length < i || nums2.length < k - i) {
                continue;
            }
            int[] nums1R = maxNumber(nums1, i);
            int[] nums2R = maxNumber(nums2, k - i);
            int[] merge = merge(nums1R, nums2R);
            if (res == null) {
                res = merge;
            } else {
                if (compare(merge,0,  res, 0) > 0) {
                    res = merge;
                }
            }
        }
        return res;
    }

    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }



    private int[] merge(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                res[k++] = nums1[i++];
            } else if (nums1[i] < nums2[j]){
                res[k++] = nums2[j++];
            } else {
                if (compare(nums1, i, nums2, j) > 0) {
                    res[k++] = nums1[i++];
                } else {
                    res[k++] = nums1[j++];
                }
            }
        }

        if (i == nums1.length) {
            while (j < nums2.length) {
                res[k++] = nums2[j++];
            }
        }
        if (j == nums2.length) {
            while (i < nums1.length) {
                res[k++] = nums1[i++];
            }
        }
        return res;
    }

    private int[] maxNumber(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int cnt = nums.length - k;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && cnt > 0 && deque.peekLast() < nums[i]) {
                deque.pollLast();
                cnt--;
            }
            deque.offerLast(nums[i]);
        }

        while (cnt > 0) {
            deque.pollLast();
            cnt--;
        }
        int size = nums.length - k > 0 ? k : nums.length;
        int[] res = new int[size];
        int i = 0;
        while (!deque.isEmpty()) {
            res[i++] = deque.pollFirst();
        }

        return res;
    }

    @Test
    public void test001() {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int[] res = maxNumber(nums1, nums2, 5);
        System.out.println("--->");
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void test002() {
        int[] nums1 = {6, 7};
        int[] nums2 = {6, 0, 4};
//        int[] res = maxNumber(nums1, nums2, 5);
//        System.out.println("--->");
//        System.out.println(Arrays.toString(res));

        System.out.println(Arrays.toString(merge(nums1, nums2)));
    }

    @Test
    public void test003() {
        int[] nums1 = {1, 2};
        int[] nums2 = {};
        int[] res = maxNumber(nums1, nums2, 2);
        System.out.println("--->");
        System.out.println(Arrays.toString(res));

    }

}

