/* Time Complexity : O(V+E) 
*   V - n 
*   E - length of trust array */
/* Space Complexity : O(V) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

class Solution {
    public int findJudge(int n, int[][] trust) {

        //Iterate over trust array, (a->b) decr arr[a] and incr arr[b]
        int[] arr = new int[n+1];//in-degree array
        for(int[] edge: trust){
            arr[edge[0]]--;
            arr[edge[1]]++;
        }
        //The judge has value equals n-1
        for(int i = 1; i <= n; i++){
            if(arr[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}