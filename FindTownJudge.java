// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We can maintain indegree matrix for all the people
// Traverse the edges and update the matrix
// The judge if exists will have n-1 incoming edges

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        for(int[] t: trust)
        {
            int in = t[1]-1;
            int out = t[0] -1;
            indegree[in]++;
            indegree[out]--;
        }
         for(int i=0;i<n;i++)
            for(int i=0;i<n;i++)
                if(indegree[i]==n-1)
                    return i+1;
        return -1;
            }
}