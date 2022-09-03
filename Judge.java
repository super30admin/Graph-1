// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==0){
            return -1;
        }
        int in[] = new int[n];
        for(int[] edge:trust){
            in[edge[1] - 1]++; 
            in[edge[0] - 1]--;
        }
        for(int i=0;i<n;i++){
            if(in[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}