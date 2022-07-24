//TC : O(n)
//SC : O(n)
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] result = new int[n];
        for(int[] trusted : trust){
            result[trusted[0] - 1]--;
            result[trusted[1] - 1]++;
        }
        for(int i = 0 ; i < n ; i++){
            if(result[i] == n - 1){
                return i + 1 ; 
            }
                
        }
        return -1;
    }
}
