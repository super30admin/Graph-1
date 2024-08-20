// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class TownJudge {
    // Using indegrees Array
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n + 1]; // labeled from 1 to n
        for (int[] edge : trust) {
            indegrees[edge[0]]--;
            indegrees[edge[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == n - 1)
                return i;
        }

        return -1;

    }
}