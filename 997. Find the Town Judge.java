// Time Complexity: O(m + n) i.e. O(V + E)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 0) return -1;
        
        int[] indegrees = new int[n];
        
        for(int[] edge : trust){
            indegrees[edge[0] - 1]--;
            indegrees[edge[1] - 1]++;
        }
        
        for(int i = 0; i < n; i++){
            if(indegrees[i] == n - 1){
                return i + 1;
            }
        }
        return -1;
    }
}