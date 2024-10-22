// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package Graph-1;

public class Problem1 {
    public int findJudge(int n, int[][] trust) {
        int [] indegree = new int [n+1];

        for(int [] edge: trust){
            indegree[edge[0]]--;
            indegree[edge[1]]++;
        }

        for(int i = 1; i <= n; i++){
            if(indegree[i] == n - 1){
                return i;
            }
        }
        return -1;
    }    
}
