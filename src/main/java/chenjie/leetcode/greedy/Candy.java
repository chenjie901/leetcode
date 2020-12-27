package chenjie.leetcode.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        System.out.println(Arrays.toString(res));
        for (int i = ratings.length - 1; i > 0; i--) {
            //左边的比右边的高
            if (ratings[i - 1] > ratings[i] && res[i - 1] <= res[i]) {
                res[i - 1] = res[i] + 1;
            }
        }
        System.out.println(Arrays.toString(res));
        return Arrays.stream(res).sum();
    }

    @Test
    public void test001() {
        int[] arr = {1, 0, 2};
        Assert.assertEquals(5, candy(arr));
    }

    @Test
    public void test002() {
        int[] arr = {1, 3, 4, 5, 2};
        Assert.assertEquals(11, candy(arr));
    }
}
