// 997.
// time - O(N + length of trust)
// space - O(n)
class Solution {
    public int findJudge(int N, int[][] trust) {
        //int[] in trust[] is of form [a,b] implying a trusts b
        //a trusts b translates to a directed edge from a to b i.e outgoing from a and incoming on b
        //if the town judge exists, then indegree of that node is n - 1 and outdegree is 0
        //if no such node is found return -1;
        //observation - no self edge
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];
        for(int[] edge : trust)
        {
            int from = edge[0];
            int to = edge[1];
            outDegree[from]++;
            inDegree[to]++;
        }
        for(int i = 1; i <= N; i++)
        {
            if(inDegree[i] == N - 1 && outDegree[i] == 0)
            {
                return i;
            }
        }
        return -1;
    }
}
