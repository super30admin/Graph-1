// Time Complexity : O(V+E)
// Space Complexity : O(V)
// V is the given number of people in input array trusts
// E is the trust/trusted links
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int findJudge(int n, int[][] trusts) {
        int[] indegree = new int[n];
        for(int[] trust : trusts){
            indegree[trust[0]-1]--;
            indegree[trust[1]-1]++;
        }

        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == n-1)
                return i+1;
        }
        return -1;
    }
}