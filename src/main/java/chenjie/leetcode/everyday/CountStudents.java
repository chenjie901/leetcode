package com.chenjie;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CountStudents {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack  = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            q.offer(students[i]);
        }
        Queue<Integer> tmp = new LinkedList<>();
        while (!stack.isEmpty()) {
            int matchCnt = 0;
            while (!q.isEmpty()) {
                int s  = q.poll();
                tmp.offer(s);
                if (s == stack.peek()) {
                    matchCnt++;
                }
            }
            q = tmp;
            if (matchCnt == 0) {
                break;
            }

            tmp = new LinkedList<>();
            int stu = q.poll();
            if (stu != stack.peek()) {
                q.offer(stu);
            } else {
                stack.pop();
            }
        }
        return q.size();
    }

    public int countStudents1(int[] students, int[] sandwiches) {
        int[] cnts = new int[2];
        for (int i = 0; i < students.length; i++) {
            cnts[students[i]]++;
        }
        for (int i = 0;i < sandwiches.length; i++) {
            if (--cnts[students[i]] == -1) {
                return sandwiches.length - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches  = {1,0,0,0,1,1};
        CountStudents countStudents = new CountStudents();
        System.out.println(countStudents.countStudents(students, sandwiches));
    }
}
