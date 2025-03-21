// Time Complexity : O(v+e) where v - vertices, e - edges.
// Space Complexity : O(v) v - vertices.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n];
        for(int i=0; i<trust.length; i++)
        {
            int x = trust[i][0];
            int y = trust[i][1];
            degree[y-1] += 1;
            degree[x-1] -= 1;
        }

        for(int i=0; i<n; i++)
            if(degree[i] == n-1) return i+1;
        return -1;
    }
}