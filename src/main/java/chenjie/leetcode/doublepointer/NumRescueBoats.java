package chenjie.leetcode.doublepointer;

import java.util.Arrays;

//881. 救生艇
public class NumRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int ans = 0;
        while (left < right) {
            if (people[left] + people[right] <= limit) {
                ans++;
                left++;
                right--;
            } else {
                right--;
                ans++;
            }
        }
        ans++;
        return ans;
    }
}
