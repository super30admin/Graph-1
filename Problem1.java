class Solution {
    //TC: O(V+E)
    //SC: O(V)
    public int findJudge(int n, int[][] trust) {
        int [] indegress = new int[n+1];
        for(int [] edge : trust){
            indegress[edge[0]]--;
            indegress[edge[1]]++;
        }
        for(int i =1; i <= n; i++){
            if(indegress[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}
