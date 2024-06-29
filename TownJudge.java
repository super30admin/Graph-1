// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/find-the-town-judge/
// Any problem you faced while coding this : No

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[]indegrees = new int[n+1];
        for(int[] edge:trust){
            indegrees[edge[0]]--;
             indegrees[edge[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(indegrees[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}
