/**
 * Time complexity is O(V + E) -- verices and edges
 * space complexity is O(V)
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] indegrees = new int[n+1];
        int[] outdegrees = new int[n+1];
        
        for(int[] edge : trust) {
            int x = edge[0];
            int y = edge[1];
            indegrees[y] = indegrees[y] + 1;
            outdegrees[x] = outdegrees[x] + 1;
        }
        
        for(int i = 1; i <= n; i++) {
            if(outdegrees[i] == 0 && indegrees[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
}