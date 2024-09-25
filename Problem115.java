//TC: O(n+t)
//SC: O(n)

class Solution {
    public int findJudge(int n, int[][] trust) {
        // Array to track trust counts
        int[] trustCount = new int[n + 1];

        // Process each trust relationship
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            trustCount[a]--; // a trusts someone, so decrement a's count
            trustCount[b]++; // b is trusted by someone, so increment b's count
        }

        // Find the person who is trusted by exactly n-1 people and trusts no one
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i; // This person is the judge
            }
        }

        return -1; // No judge found
    }
}
