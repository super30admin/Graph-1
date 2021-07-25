package Graph1;

/*S30 FAANG Problem #114 {Easy}  -- https://www.youtube.com/watch?v=R6S8SjdbWYk

    In a town, there are N people labelled from 1 to N.  There is a person who is secretly the town judge.

    If the town judge exists, then:

    The town judge trusts nobody.
    Everybody trusts the town judge except for the town judge.
    There is exactly one person that satisfies properties 1 and 2.
    Given an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

    If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

    Example 1:
    Input: N = 2, trust = [[1,2]]
    Output: 2

    Example 2:
    Input: N = 3, trust = [[1,3],[2,3]]
    Output: 3



    Example 3:
    Input: N = 3, trust = [[1,3],[2,3],[3,1]]
    Output: -1

    Example 4:
    Input: N = 3, trust = [[1,2],[2,3]]
    Output: -1



    Example 5:
    Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
    Output: 3

    Source Link: https://leetcode.com/problems/find-the-town-judge/

-------------------------------------------------------------------------------------------------------
Time complexity :O(N) 
space complexity:O(N) 
Approach:
Did this code run successfully in leetcode : yes
problems faces : no*/


public class TownJudge {
    
  public int findJudge(int n, int[][] trust) {
        
      int[] indegrees = new int[n];
      
      for(int[] t : trust)
      {
          indegrees[t[0]-1]--;
          indegrees[t[1]-1]++;
      }
      
      for(int i=0;i<indegrees.length;i++)
      {
          if(indegrees[i] == n-1)
              return i+1;
      }
          
      
      return -1;
    }

}
