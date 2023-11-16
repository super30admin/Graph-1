// Time Complexity:  O(V+E)
// Space Complexity: O(V)

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n];
        for(int[] t : trust) {
            degree[t[0]-1]--;                // decrementing for outdegree
            degree[t[1]-1]++;                // incrementing for indegree
        }
        int i=0;
        for(int d : degree) {
            if(d == n-1)                     // found number with all indegrees
                return i+1;                  // return index
            i++;
        }
        return -1;
    }
}
