package chenjie.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeSort {

    int count = 0;



    @Test
    public void testMergeSort() {
        int[] arr = {7, 5, 6, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }

    @Test
    public void testMerge() {
        int[] arr = {1, 4, 3, 5, 6};
        int[] temp = new int[arr.length];
        merge(arr, 0, 1, 3,temp);
        System.out.println(Arrays.toString(arr));

    }

    public void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    public void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }

    }

    public void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                count = count + mid - i + 1;
                temp[t++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }

        t = 0;

        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }
}
