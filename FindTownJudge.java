// Using : Graph
// TC : O(V+E)
// SC : O(V)
class Solution {

    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        for(int[] tr : trust){
            indegree[tr[0] -1]--;
            indegree[tr[1] -1]++;
        }
        for(int i= 0; i<n;i++){
            if(indegree[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}
