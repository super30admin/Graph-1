// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1)
            return 1;
        if(trust==null||trust.length==0)
            return -1;
        
        int[] indegrees = new int[n+1];
        
        for(int[] t:trust){
            indegrees[t[0]]--;
            indegrees[t[1]]++;
        }
        
        for(int i = 0;i<indegrees.length;i++){
            if(indegrees[i]==n-1)
                return i;
        }
        return -1;
    }
}
