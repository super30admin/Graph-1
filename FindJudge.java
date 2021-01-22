// Time Complexity : O(V + E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// As we iterate through the trust matrix, we build an array 'degree' with 
// values indegree minus outdegree for the node represented by index
// index with value N - 1 is the judge
class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if(N == 0) return -1;
        
        int[] degree = new int[N + 1];
        
        for(int[] rel: trust) { // O(E)
            degree[rel[1]]++;
            degree[rel[0]]--;
        }
        
        for(int i = 1; i <= N; i++) { //O(V)
            if(degree[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}