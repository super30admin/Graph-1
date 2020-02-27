//TC - O(N)
//SC - O(N)

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust == null || trust.length == 0) return 1;
        
        int[] outdegree = new int[N];
        int[] indegree = new int[N];
        
        for(int[] t : trust)
        {
            ++outdegree[t[0]-1];
            ++indegree[t[1] - 1];
        }
        
        for(int i = 0 ;i < N; ++i)
        {
            if(outdegree[i] == 0 && indegree[i] == N-1) return i + 1;
        }
        
        return -1;
    }
}
