package chenjie.leetcode.array;

import org.junit.Test;

public class ArrayZigZag {
    @Test
    public void testZigZag() {
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        printArrayZigZag(arr);
    }

    boolean direction = true;

    @Test
    public void testPrintArray() {
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        printArr(arr);
    }

    public void printArrayZigZag(int[][] arr) {
        int tr = 0, tc = 0, dr = 0, dc = 0;
        int endR = arr.length;
        int endC = arr[0].length;
        while (tr != endR) {
//            System.out.printf("<%d, %d>, <%d,%d>\n", tr, tc, dr,dc);
            print(arr, tr, tc, dr, dc);
            tr = tc == endC - 1 ? tr + 1 : tr;
            tc = tc == endC - 1 ? tc : tc + 1;
            dc = dr == endR - 1 ? dc + 1 : dc;
            dr = dr == endR - 1 ? dr : dr + 1;
        }
    }

    public void printArr(int[][] arr) {
        int tr = arr.length - 1;
        int tc = arr[0].length - 1;
        int dr = arr.length - 1;
        int dc = arr[0].length - 1;
        while (tc != -1) {
            System.out.printf("<%d, %d>, <%d,%d>\n", tr, tc, dr, dc);
//            print(arr, tr, tc, dr, dr);

            tc = tr == 0 ? tc - 1 : tc;
            tr = tr == 0 ? tr  : tr -1;
            dr = dc == 0 ? dr - 1 : dr;
            dc = dc == 0 ? dc : dc - 1;
        }
    }

    public void print(int[][] arr, int tr, int tc, int dr, int dc) {
        if (direction) {
            while (tr != dr + 1) {
                System.out.printf("%d ", arr[tr][tc]);
                tr++;
                tc--;
            }
            System.out.println();

        } else {
            while (dr != tr - 1) {
                System.out.printf("%d ", arr[dr][dc]);
                dr--;
                dc++;
            }
            System.out.println();
        }
        direction = !direction;
    }

}
