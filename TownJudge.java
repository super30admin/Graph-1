// Time Complexity : O(V+E)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach :
/*
 * 1 - Create an indegree array which will maintain the indegree for each element.
 * 2 - In the end, check which element has indegree equal to n - 1. This will be the town judge.
 */

public class TownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        
        for(int[] t: trust)
        {
            indegree[t[0]-1]--;
            indegree[t[1]-1]++;
        }
        
        for(int i = 0; i < n;i++)
        {
            if(indegree[i] == n - 1)
            {
                return i + 1;
            }
        }
        return -1;
    }
}
