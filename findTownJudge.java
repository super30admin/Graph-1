// Time Complexity : O(E + V)
// Space Complexity : O(N), storing indegrees in array of size N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class findTownJudge {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) {
            return -1;
        }

        int[] inDegrees = new int[n + 1];

        for (int[] relation : trust) {
            inDegrees[relation[0]]--;
            inDegrees[relation[1]]++; 
        }

        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
