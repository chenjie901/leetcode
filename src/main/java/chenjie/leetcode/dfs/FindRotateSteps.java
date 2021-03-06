package chenjie.leetcode.dfs;

import org.junit.Assert;
import org.junit.Test;

/**
 * 514. 自由之路
 * 电子游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
 *
 * 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 *
 * 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 *
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 *
 * 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 */
public class FindRotateSteps {

    public int findRotateSteps(String ring, String key) {
        return dfs(ring, key, 0, 0);
    }
    //从start位置走的最短路径
    int dfs(String ring, String key, int index, int start) {
        if (index == key.length()) {
            return 0;
        }
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) != key.charAt(index)) {
                continue;
            }
            int dif = Math.abs(i - start);
            int distance = 1 + Math.min(dif, ring.length() - dif) + dfs(ring, key, index + 1, i);
            minPath = Math.min(minPath, distance);
        }
        return minPath;
    }

    @Test
    public void test001() {
        Assert.assertEquals(4, findRotateSteps("caotmcaataijjxi", "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));
    }
}
