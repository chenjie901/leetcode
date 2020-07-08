package chenjie.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

public class HalfMajor {

    @Test
    public void test001() {
        int[] arr = new int[]{0, 1, 2, 1, 1};
        printHalfMajor(arr);
    }


    public void printHalfMajor(int[] arr) {
        int cand = 0;
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (times == 0) {
                cand = arr[i];
                times = 1;
            } else if (arr[i] == cand) {
                times++;
            } else {
                times--;
            }
        }

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cand == arr[i]) {
                cnt++;
            }
        }

        if (cnt > arr.length / 2) {
            System.out.println(cand);
        } else {
            System.out.println("not foud");
        }

    }
}
