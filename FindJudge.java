// TC: O(V+E)
// SC: O(V)
// Runs on LeetCode: YES

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] adjArr = new int[n + 1];

        for (int[] curr : trust) {
            adjArr[curr[0]]--;
            adjArr[curr[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (adjArr[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}