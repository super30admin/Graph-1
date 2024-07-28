// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==0){
            return -1;
        }

        int[] indegrees = new int[n];
        for(int[] t : trust){
            indegrees[t[0] -1]--;
            indegrees[t[1] -1]++; 
        }
        for(int i=0; i<n; i++){
            if(indegrees[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}