//TC: O(N)
//SC: O(N)

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] indegree = new int[N+1];
        int[] outdegree = new int[N+1];
        
        for(int i=0; i<trust.length; i++)
        {
            indegree[trust[i][0]] +=1;
                outdegree[trust[i][1]] +=1;
        }
        
        for(int i=1; i<N+1;i++)
        {
            if(outdegree[i] == N-1 && indegree[i] == 0)
                return i;
        }
return -1;
    }
}