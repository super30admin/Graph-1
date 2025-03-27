// Time Complexity: O(N+E) where N is the number of people and E is the number of edges
// Space Complexity: O(N)
class TownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] res = new int[n+1];

        for(int i = 0; i < trust.length; i++){
            int from = trust[i][0];
            int to = trust[i][1];

            res[from]--;
            res[to]++;
        }

        for(int i = 1; i < res.length; i++){
            if(res[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}
