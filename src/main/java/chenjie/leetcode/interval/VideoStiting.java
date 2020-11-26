package chenjie.leetcode.interval;

import org.junit.Assert;
import org.junit.Test;

public class VideoStiting {

    public int videoStitching(int[][] clips, int T) {
        int[] maxn = new int[T];
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(clip[1], maxn[clip[0]]);
            }
        }
        int pre = 0;
        int last = 0;
        int ret = 0;
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (last == i) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }

    @Test
    public void test001() {
        int[][] clips = new int[][]{{0, 4}, {2, 6}, {5, 10}};
        int ret = videoStitching(clips, 10);
        Assert.assertEquals(3, ret);
    }
}
