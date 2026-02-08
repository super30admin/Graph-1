// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Count the number of incoming and outgoing edges for each person
// for town judge, total of n-1 incoming edges and 0 outgoing edges
// indegree should be n-1 

class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] indegrees = new int[n+1];
        for(int[] edge:trust){ //O(E)
            indegrees[edge[0]]--;
            indegrees[edge[1]]++;
        }

        for(int i=1;i<indegrees.length;i++) //O(V)
            if(indegrees[i]==n-1) return i;
        
        return -1;
    }
}