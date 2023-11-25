// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findJudge(int n, int[][] trust) {
       int[] count = new int[n+1];
       for(int[] edge : trust){
           count[edge[1]]++;
           count[edge[0]]--;
       }
       for(int i = 1; i <=n; i++){
           if(count[i]==n-1)
            return i;
       }
       return -1;
    }
}