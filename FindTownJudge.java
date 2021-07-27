//Time Complexity - O(V+E) where v is number of vertices and e number of edges
//Space Complexity - O(V)

class Solution {
    public int findJudge(int n, int[][] trust) {
        //create indegree array
      int[] indegreeArr = new int[n];
      for(int[] t : trust) {
        //reduce the indegree count if the person is trusting some one
        indegreeArr[t[0]-1] --;
        //increase the indegree if the person is receving the trust
        indegreeArr[t[1]-1] ++;
      }
      
      for(int i=0; i<indegreeArr.length; i++) {
        if(indegreeArr[i] == n-1) {
          //if indegreecount is one less than total number of people then return the person index
          return i+1;
        }
      }
      return -1;
    }
}