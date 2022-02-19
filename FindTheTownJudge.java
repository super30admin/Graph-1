// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];

        for(int[] t : trust){
            indegree[t[1]-1]++;
            indegree[t[0]-1]--;
        }

        for(int i = 0; i < n; i++) {
            if(indegree[i] == n-1) {
                return i+1;
            }
        }
        return -1;
    }
}