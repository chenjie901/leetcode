package chenjie.leetcode.dfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LeetCode130 {

    public boolean isSame(char[][] expeced, char[][] actual) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (expeced[i][j] != actual[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test001() {
        char[][] board = new char[][] {
                {'x','x', 'x', 'x'},
                {'x','o', 'o', 'x'},
                {'x','x', 'o', 'x'},
                {'x','0', 'x', 'x'},
        };


        char[][] expected = new char[][] {
                {'x','x', 'x', 'x'},
                {'x','x', 'x', 'x'},
                {'x','x', 'x', 'x'},
                {'x','0', 'x', 'x'},
        };

        solve(board);

        Assert.assertTrue(isSame(expected, board));
    }

    @Test
    public void test002() {
        char[][] board = new char[][] {
                {'O','O'},
                {'O','O'}

        };


        char[][] expected = new char[][] {
                {'O','O'},
                {'O','O'}
        };

        solve(board);

        Assert.assertTrue(isSame(expected, board));
    }

    @Test
    public void test003() {
        char[][] board = new char[][] {
                {'X','O', 'X'},
                {'O','X', 'O'},
                {'X','O', 'X'}
        };


        char[][] expected = new char[][] {
                {'X','O', 'X'},
                {'O','X', 'O'},
                {'X','O', 'X'}
        };

        solve(board);

        Assert.assertTrue(isSame(expected, board));
    }

    int R;
    int C;
    int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        R = board.length;
        C = board[0].length;
        int[][] visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'O' && (i == R - 1 || j == C - 1 || i ==0 || j == 0)) {
                    dfs(board, visited, i, j);
                }
            }
        }

        Arrays.stream(visited).forEach(c -> System.out.println(Arrays.toString(c)));
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(char[][] board, int[][] visited, int r0, int c0) {

        visited[r0][c0] = 1;

        for (int[] d : direction) {
            int r1 = r0 + d[0];
            int c1 = c0 + d[1];
            if (r1 < 0 || r1 >= R - 1 || c1 < 0 || c1 >= C - 1) {
                continue;
            }

            if (visited[r1][c1] == 1) {
                continue;
            }

            if (board[r1][c1] == 'X') {
                continue;
            }
            dfs(board, visited, r1, c1);
        }
    }


}
