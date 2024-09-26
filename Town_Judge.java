// Time Complexity :O(E)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust.length < N-1){
            return -1;
        }
        
        int[] inDegree = new int[N+1];
        int[] outDegree = new int[N+1];
        
        for(int[] relation : trust){
                outDegree[relation[0]]++;
                inDegree[relation[1]]++;
        }
        
        for(int i = 1; i <=N; i++){
            if(inDegree[i] == N-1 && outDegree[i] == 0){
                return i;
            }
        }
        
        return -1;
    }
}