// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes, 2ms
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Decrement the count for all the people who trust, and increment for the ones who are trusted, whichever position reaches the count N-1, is the judge

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        int[] count = new int[N+1];
        
        for(int[] t: trust){
            
            count[t[0]]--;
            count[t[1]]++;
        }
        
        for(int i = 1; i <= N; i++){
            
            if(count[i] == N-1){
                return i;
            }
        }
        
        return -1;
        
    }
}
