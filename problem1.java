public class problem1 {

    // Time Complexity: 0(V+E)
    // Space Complexity: 0(V)

    public int findJudge(int n, int[][] trust) {
        int[] indegree= new int[n+1];

        for(int[] tr: trust)
        {
            indegree[tr[0]]--;
            indegree[tr[1]]++;

        }
        for(int i=1;i<=n;i++)
        {
            if(indegree[i]==n-1)
            {
                return i;
            }

        }
        return -1;
    }
}
