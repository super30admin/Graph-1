// Time Complexity : O(V+E) -> number of vertices + number of dependencies(edges)
// Space Complexity : O(V) -> space of indegree array (number of vertices)
// Did this code successfully run on Leetcode : Yes

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {

        int[] indegree = new int[n+1];

        for(int[] tru: trust)
        {
            indegree[tru[1]]++;
            indegree[tru[0]]--;
        }
        for(int i=1; i<=n; i++)
        {
            if(indegree[i] == n-1)
            {
                return i;
            }
        }
        return -1;
    }
}
