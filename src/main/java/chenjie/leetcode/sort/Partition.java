package chenjie.leetcode.sort;

import chenjie.leetcode.ListNode;
import org.junit.Test;

import java.util.*;

public class Partition {

    @Test
    public void testPartition() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n6.next = null;
        n5.next = n6;
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;

        ListNode head = partition(n1, 3);
        while (head != null) {
            System.out.print(head.val + "-->");


            head = head.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode t = head;
        while (t.next != null) {
            if (t.val == x) {
                break;
            }
            t = t.next;
        }
        ListNode pre = t;
        ListNode cur = t;
        while (cur != null) {
            if (cur.val < x) {
                pre.next = cur.next;
                insert(head, cur, t);
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    public void insert(ListNode head, ListNode n, ListNode e) {
        ListNode pre = head;
        while (head != e) {
            if (head.val > n.val) {
                n.next = head;
                pre.next = n;
            }
            pre = head;
            head = head.next;
        }
    }

    @Test
    public void testReplaceWords() {
        String sentence = "the cattle was rattled by the battery";
        String res = replaceWords(Arrays.asList("cat", "ba", "rat"), sentence);
        System.out.println(res);
    }

    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split("\\s");
        dict.sort((a, b) -> a.length() - b.length());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (String root : dict) {
                if (word.startsWith(root)) {
                    words[i] = root;
                    break;
                }

            }

            sb.append(words[i] + " ");
        }
        return sb.toString().trim();

    }

    class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Test
    public void testExit() {
        char[][] borad = new char[][]{
                {'a', 'b', 'c'},
                {'m', 'k', 'j'},
                {'r', 's', 'z'}
        };

        System.out.println(exist(borad, "bkszjq"));
    }
    //判读二维数组中是否存在某个单词
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        int[][] d = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        Queue<Position> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == word.charAt(0)) {
                    queue.offer(new Position(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Stack<Position> stack = new Stack<>();
            Position pos = queue.poll();
            stack.push(pos);
            boolean[][] visited = new boolean[r][c];
            visited[pos.x][pos.y] = true;
            while (!stack.isEmpty()) {
                for (int p = 1; p < word.length(); p++) {
                    Position curP = stack.pop();
                    visited[curP.x][curP.y] = true;
                    char c1 = word.charAt(p);
                    for (int i = 0; i < 4; i++) {
                        int newX = curP.x + d[i][0];
                        int newY = curP.y + d[i][1];

                        if (inArea(board, newX, newY) && !visited[newX][newY]) {
                            if (board[newX][newY] == c1) {
                                if (p == word.length() - 1) {
                                    return true;
                                }
                                stack.push(new Position(newX, newY));
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean inArea(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }


}
