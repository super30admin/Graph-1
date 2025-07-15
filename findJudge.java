class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degrees = new int[n+1];
        for(int[] edge : trust){
            degrees[edge[0]]--;
            degrees[edge[1]]++;
        }

        for(int i = 1; i < degrees.length; i++){
            if(degrees[i] == n-1) return i;
        }

        return -1;
    }
}
