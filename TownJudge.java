//DP
//time o(N)
//space o(N)
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] dp = new int[N];
        
        for(int i=0;i<trust.length;i++) {
            dp[trust[i][1]-1]++;
            dp[trust[i][0]-1]--;
        }
        
        for(int i=0;i<N;i++) {
            if(dp[i] == N-1)
            {
                return i+1;
            }
        }
        return -1;
    }
}