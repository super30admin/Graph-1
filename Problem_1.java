// Time complexity - O(m+n), N - Number of People, M - Number of edges
// Space complexity - O(N)

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust == null)  return -1;
        int[] degrees = new int[N];
        for(int[] i : trust){
            degrees[i[0] - 1]--;
            degrees[i[1] - 1]++;
        }
        
        for(int i = 0; i < degrees.length; i++){
            if(degrees[i] == N-1){
                return i+1;
            }
        }
        return -1;
    }
}
