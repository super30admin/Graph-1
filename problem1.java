// Problem2 - https://leetcode.com/problems/the-maze/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding base cases

public class problem1 {
    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0)
            return N == 1 ? 1 : -1;
        int[] trustCount = new int[N + 1];
        for (int[] t : trust) {
            trustCount[t[1]]++;
            trustCount[t[0]]--;
        }
        for (int i = 1; i < trustCount.length; i++) {
            if (trustCount[i] == N - 1)
                return i;
        }
        return -1;
    }
}
