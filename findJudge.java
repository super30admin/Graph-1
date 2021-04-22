// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :N/A
// Any problem you faced while coding this :Test cases


// Your code here along with comments explaining your approach
class Solution {
    public int findJudge(int N, int[][] trust) {
      
      //ceate in degree and out degree array. In in degree we store all the a's and in out degree we store the b's from [a,b]
      int[] in_deg = new int[N+1];
      int[] out_deg = new int[N+1];
      

      for(int i=0;i<trust.length;i++)
      {
        in_deg[trust[i][0]]=in_deg[trust[i][0]]+1;
        
        out_deg[trust[i][1]]=out_deg[trust[i][1]]+1;
      }
      //the person with 0 in indegree and N-1 in out degree will be the judge
      int judge = -1;
      for(int i=0;i<N+1;i++)
      {
        if(out_deg[i]==N-1 && in_deg[i]==0)
        {
          judge = i;
        }
      }
        return judge;
    }
}