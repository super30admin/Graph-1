// Time Complexity : O(E)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Indegree and outdegree
class Solution {
    public int findJudge(int N, int[][] trust) {
        
        int[] indegree = new int[N+1];
        int[] outdegree = new int[N+1];
        
        for(int[] relation: trust){
            indegree[relation[1]]++;
            outdegree[relation[0]] ++;
        }
        
        for(int i=1; i<=N; i++){
            if(indegree[i]==N-1 && outdegree[i]==0){
                return i;
            }
        }
        return -1;
        
    }
}