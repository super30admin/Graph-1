// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        int[] arr = new int[N];
        
        for(int[] t:trust){
            arr[t[0]-1]--;
            arr[t[1]-1]++;
        }
        
        for(int i=0;i<N;i++){
            if(arr[i]==N-1)
                return i+1;
        }
      return -1;  
    }
} 	