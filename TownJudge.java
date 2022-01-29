// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We create a indegrees array
// we iterate through the trust array and we take them as edges
// If a person trust someone we decrement the value and vise versa
// then we iterate through the indegrees and if we find any element greater than n-1 we return it
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 0)
            return -1;
        int[] indegrees = new int[n];
        for (int[] edge : trust) {
            indegrees[edge[0] - 1]--;
            indegrees[edge[1] - 1]++;
        }
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}