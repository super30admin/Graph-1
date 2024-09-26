// Using 2 arrays
// Time Complexity: O(n)
// Space Complexity: O(n)
 class Solution {
     public int findJudge(int N, int[][] trust) {
         int[] indegrees = new int[N+1];
         int[] outdegrees = new int[N+1];

         for(int[] arr: trust) {
             outdegrees[arr[0]]++;
             indegrees[arr[1]]++;
         }

         for(int i = 1; i <= N; i++) {
             if(outdegrees[i] == 0 && indegrees[i] == N -1) {
                 return i;
             }
         }
         return -1;
     }
 }

// Using 1 array
// Time Complexity: O(n)
// Space COmplexity: O(n)
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust.length < N-1) {
            return -1;
        }
        int[] trustScores = new int[N+1];

        for(int[] arr : trust) {
            trustScores[arr[0]]--;
            trustScores[arr[1]]++;
        }

        for(int i=1; i<=N; i++) {
            if(trustScores[i] == N-1) {
                return i;
            }
        }
        return -1;
    }
}