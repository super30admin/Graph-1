// In this problem, considering the people as vertices and the relationship between them as the edges. Any node having n-1 incoming
// edges (indicating that all people except himself trusts him) and 0 outgoing edges (indicating he trusts no one), is the town
// judge. Maintaining a indegree array and doing -1 everytime there is outgoing edge and +1 for incoming edge. At the end, 
// traversing through that indegree array and at any index n-1 value found then returning that index+1.

// Time Complexity : O(V+E)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int findJudge(int n, int[][] trust) {
        // Base
        if (n == 0) {
            return -1;
        }
        // Declare indegrees array
        int[] indegree = new int[n];
        for (int[] t : trust) {
            // 0 index in each trust relationship indicates outgoing edge from that node eg.
            // [1,2] means 1 trust on 2, so outgoing edge from one and incoming edge on 2
            indegree[t[0] - 1]--;
            indegree[t[1] - 1]++;
        }
        // Iterate through indegree array and check for n-1
        for (int i = 0; i < n; i++) {
            if (indegree[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}