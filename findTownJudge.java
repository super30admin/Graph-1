// Time Complexity : O(N + M) where N = the number of people(nodes) and M = the number of relations(edges)
// Space Complexity : O(N )
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n];
        
        for(int[] t: trust) {
            indegrees[t[1] - 1] ++;
            indegrees[t[0] - 1] --;
        }
        
        for(int i=0;i<indegrees.length;i++) {
            if(indegrees[i] == n-1) return i+1;
        }
        return -1;
    }
}
