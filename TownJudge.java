//O(E) time: number of edges (trust relationships)
// O(N) space: allocating array of length n, number of ppl

class Solution {
    public int findJudge(int n, int[][] trust) {  
        int[] trustScores = new int[n + 1]; // length of number of people (+1 because n people labelled 1 to n, not 0 to n-1)
        
        for (int[] relation : trust){
            trustScores[relation[0]]--; // each person loses a point for each person they trust
            trustScores[relation[1]]++; // each person wins a point for each person that trusts them
        }
        
        for (int i = 1; i <= n; i++){ // check if there's someone at the end with n-1 points
            if (trustScores[i] == n - 1){
                return i;
            }
        }
        
        return -1;
    }
}