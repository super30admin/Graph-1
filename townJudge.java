//Time Complexity: O(v+e)
//Spce Complexity: O(n)

class townJudge {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        for(int[] edge : trust){
            indegree[edge[0] -1]--;
            indegree[edge[1] -1]++;
        }
        for(int i=0; i<n; i++){
            if(indegree[i]==n-1) return i+1;
        }
        return -1;
    }
}