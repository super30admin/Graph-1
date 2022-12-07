class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] j = new int[n+1];
        int[] o = new int[n+1];

        for(int[] e : trust){
            j[e[1]]++;
            o[e[0]]++;
        }
        for(int i = 1; i<=n; ++i){
            if(j[i]==n-1 && o[i]==0){
                return i;
            }
        }
        return -1;
    }
}
//tc=O(n)
//sc=O(n)
