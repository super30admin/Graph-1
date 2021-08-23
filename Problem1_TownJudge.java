// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findJudge(int n, int[][] trust) {
        
        if(trust==null)
            return 0;
        if(n==1)
            return 1;
        if(trust.length < n-1)
            return -1;
        
        int[] indegree=new int[n];
        
        for(int[] t:trust)
        {
            indegree[t[0]-1]--; //outgoing edge
            indegree[t[1]-1]++; //incoming edge   
        }
        
        for(int i=0;i<n;i++)
        {
            if(n-1 == indegree[i])
                return i+1;
        }
        
        return -1;
    }
}