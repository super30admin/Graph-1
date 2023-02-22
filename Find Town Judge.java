// Time Complexity = O(V+E) 
// Space Complexity = O(V)

class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] indegrees = new int[n];
        for(int [] tr : trust){
            int in = tr[1] - 1; 
            int out = tr[0] -1;
            indegrees[in] += 1;
            indegrees[out] -= 1;
        }
        
        for(int i = 0; i<n;i++){
            if(indegrees[i] == n-1){
                return i+1;
            }
        }
        return -1;
        
    }
}