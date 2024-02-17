/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m+n) == O(V+E)
    m = trust pairs
    n = no of people
* 
* Space Complexity: O(n) == O(V)
    n = no of people
* 
*/

public class FindATownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] topologicalSort = new int[n + 1];

        for (int index = 0; index < trust.length; index++) {
            int indegree = trust[index][1];
            int outdegree = trust[index][0];

            topologicalSort[outdegree]--;
            topologicalSort[indegree]++;
        }

        for (int index = 1; index <= n; index++) {
            if (topologicalSort[index] == n - 1) {
                return index;
            }
        }

        return -1;
    }
}
