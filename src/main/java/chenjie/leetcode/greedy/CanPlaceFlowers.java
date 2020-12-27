package chenjie.leetcode.greedy;

import org.junit.Assert;
import org.junit.Test;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                n--;
                return n <= 0;
            }
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }

            if (i == 0 ) {
                if (flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i - 1] == 0 ) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                //可以种花
                flowerbed[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }

    @Test
    public void test001() {
        int[] arr = {0, 1, 0};
//        Assert.assertEquals(true, canPlaceFlowers(arr, 1));
        Assert.assertEquals(false, canPlaceFlowers(arr, 1));
    }
}
