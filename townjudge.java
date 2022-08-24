// TC : O(m+n)
// SC : O(n)

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==0) return -1;
        
        int[] result = new int[n];
        
        for(int[] edge : trust){
            result[edge[0]-1]--;
            result[edge[1]-1]++;
        }
        for(int i=0;i<result.length;i++){
            if(result[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}