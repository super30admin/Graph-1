//997 - Find the town judge
// time - O(n)
// space - O(n)
class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] arr = new int[n + 1];
        
        for(int[] rel : trust){
            
            int outGoing = rel[0];
            int inComing = rel[1];
            
            arr[outGoing]--;
            arr[inComing]++;
        }
        
        for(int i = 1; i <= n; i++){
            if(arr[i] == n - 1){
                return i;
            }
        }
        
        return -1;
    }
}