// Time Complexity : O(m+n)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] indegrees = new int[n];
        for(int [] t: trust){
            indegrees[t[0]-1]--;
            indegrees[t[1]-1]++;
        }
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}