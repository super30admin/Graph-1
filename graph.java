class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0) return n == 1 ? 1:-1;
        int[] t = new int[n];
        int[] trusted = new int[n];
        for(int i = 0;i<trust.length;i++){
            int a = trust[i][0];
            int b = trust[i][1];
            t[a-1]++;
            trusted[b-1]++;
        }
        for(int i = 0;i<n;i++){
            if(t[i] == 0 && trusted[i]==n-1)return i+1;           
        }
    return -1;}
    
}