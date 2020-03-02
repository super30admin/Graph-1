//Brute Force
//TC : O(E) , where E is the number of edges
//SC : O(N) , where N is the number of elements
class Solution {
    public int findJudge(int N, int[][] trust) {
          if(trust.length == 0 || trust == null)
            return N;
        
          int[] indegrees = new int[N];
          int[] outdegrees = new int[N];
        
          for(int[] t : trust){
              int person = t[0];
              int potentialJudge = t[1];
              
              outdegrees[person-1]++;
              indegrees[potentialJudge-1]++;
              
          }
        
        
        for(int i=0;i<N;i++){
            //Judge Criteria
            if(indegrees[i] == N-1 && outdegrees[i] == 0)
                return i+1;
            
        }
        return -1;
    }
}