// Time Complexity : O(E + V)
// Space Complexity :O(V + V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// for the town judge indegree would be N-1 and also outdegree should be 0
// implemented it with hashmap before but that was found to be slower than array lookup

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] indegree = new int[N+1];
        int[] outdegree = new int[N+1];
        
        for(int[] pair : trust){
            indegree[pair[1]]++;
            outdegree[pair[0]]++;
        }
        
        for(int i=1; i<=N; i++){
            if(indegree[i]==N-1 && outdegree[i]==0){
                return i;
            }
        }
        
        return -1;
    }
}