//TC : O(N)
//SC : O(N)

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degrees = new int[n];
        for(int[] t : trust){ // For each pair in trust array
            int p = t[1];
            int c = t[0];
            degrees[p-1]++; // Parent node's degree incresing by 1
            degrees[c-1]--; //Child node's degree decresing by 1
        }
        
        for(int i = 0; i< degrees.length; i++){
            if(degrees[i] == n-1){ // If there is a judge then it's degree will be exactly n-1
                return i+1;
            }
        }
        
        return -1;
    }
}