// Find the Town Judge

// Time Complexity : O(V+E)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n+1];
        for(int[] tr : trust){
            indegrees[tr[0]]--;
            indegrees[tr[1]]++;
        }
        for(int i = 1; i <= n; i++){
            if(indegrees[i] == n-1)
                return i;
        }
        return -1;
    }
}