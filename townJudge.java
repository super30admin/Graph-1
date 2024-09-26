/**
    Time Complexity: O(E) no of edges -> not sure
    Space Complexity: O(N) length of trust array
**/

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if(trust == null || trust.length == 0) 
            return 1;
        
        //for each vertices in graph, tracking the incoming and outgoing arrows
        int[] indegree = new int[N+1];
        int[] outdegree = new int[N+1];
        
        /* if there is an edge i.e. trusts exist between a & b 
            add those in both the arrays */
        for(int[] edge : trust)
        {
            int a = edge[0];
            int b = edge[1];
            indegree[b]++;
            outdegree[a]++;
        }
        
        /**
        indegree :: [0, 0, 3, 2]
        outdegree :: [2, 2, 0, 1]
        need to find a vertex who has indegree -> N- 1(everybody trusts the judge)
        && outdegree 0 (town trusts nobody)
        */
        
        for(int i=1; i<=N; i++)
        {
            if(indegree[i] == N-1 && outdegree[i] == 0)
            {
               return i;  
            }
               
        }
        
        return -1;
    }
}
