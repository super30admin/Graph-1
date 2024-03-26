// TC : O(E)
// TC : O(N)

package S30_Codes.Graph_1;

class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        if(trust.length < n-1){
            return -1;
        }

        int[] trustScores = new int[n+1];
        for(int[] cur : trust){
            trustScores[cur[0]]--;
            trustScores[cur[1]]++;
        }

        for(int i=1; i<=n; i++){
            if(trustScores[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}