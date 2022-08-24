//Time Complexity- O(V+E)
///Space complexity- O(n)
//Sucessfully ran on leetcode


class Solution {
 public int findJudge(int n, int[][] trust) {
     if( n ==0) return 0;
     
     int[] inDegrees = new int[n];
     
     for(int[] edge : trust){
         inDegrees[edge[0]-1]--;
         inDegrees[edge[1]-1]++;
     }
     for(int i =0 ; i< n ; i++){
         if(inDegrees[i] == n-1){
             return i+1;
         }
     }
     return -1;
 }
}