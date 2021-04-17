class FindTheTownJudge {

    // Time Complexity: O(N)
    // Space Complexity: O(N)

    public int findJudge(int N, int[][] trust) {
        int[] counts = new int[N];
        for(int i = 0; i < trust.length; i++){
            counts[trust[i][1] - 1]++;
            counts[trust[i][0] - 1]--;
        }
        
        for(int i = 0; i < N; i++){
            if(counts[i] == N-1)
                return i+1;
        }
        return -1;
    }
}