// Time Complexity : O()
// Space Complexity : O()
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] in = new int[N+1];
        int[] out = new int[N+1];
        for(int i= 0; i < trust.length; i++){
            out[trust[i][0]] += 1;
            in[trust[i][1]] += 1;
        }
        for(int i = 1; i <= N; i++){
            if(out[i] == 0 && in[i] == N-1)
                return i;
        }
        return -1;
    }
}
