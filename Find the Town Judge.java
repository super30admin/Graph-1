// Time Complexity : O(n)
// Space Complexity : O(1)
// Method used : Graph Indegrees

class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] indegree = new int[n + 1];

        for(int[] edge : trust)
        {
            // Outgoing edge lose the trust points
            indegree[edge[0]]--;

            // Incoming edge gains the trust points
            indegree[edge[1]]++;
        }

        for(int i = 1; i < n + 1; i++)
        {
            if(indegree[i] == n - 1) return i;
        }
        
        // No town judge found
        return -1;
    }
}