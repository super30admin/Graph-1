// Graph solution
// O(n) time complexity
// O(n) space complexity
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n+1];

        for(int[] trustArr : trust){
            inDegrees[trustArr[0]]--;
            inDegrees[trustArr[1]]++;
        } 

        for(int i = 1; i<=n ; i++){
            if(inDegrees[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}
