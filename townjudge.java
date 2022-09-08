// tc: O(k) k: length of trust array
// sc: O(n).n: population


class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1) return 1;
        int[] inout = new int[n+1];
        for(int[] t: trust){
            int in=t[1];
            int out=t[0];
            inout[in]++;
            inout[out]--;
        }
        for(int i=0;i<n+1;i++){
            if(inout[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}
