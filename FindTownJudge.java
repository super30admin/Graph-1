//Time Complexity - O(n)
//Space Complexity - O(n)
class FindTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n+1];
        indegrees[0] = -1;
        for(int[] curr: trust) {
            indegrees[curr[0]] = indegrees[curr[0]] - 1;
            indegrees[curr[1]] = indegrees[curr[1]] + 1;
        }

        for(int i=1; i<n+1; i++){
            if(indegrees[i] == n-1){
                return i;
            }
        }

        return -1;
    }
}
