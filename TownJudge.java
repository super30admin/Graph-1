/**
 * Solution 1:
 * 
 * Leetcode Execution: No Problem (One testcase missed) [Also, this solution was slow, Time: 18.34%, Space: 86.67%]
 * 
 * Time Complexity: O(t) t-> no of trust relationships
 * Space Complexity: O(n) n -> no of people, for spsace used by Set and HashMap
 * 
 * 
 * Missed TestCase:
 * -> When N = 1 and Trust Array is empty, answer should be 1, I was returning -1
 */

class Solution {
  public int findJudge(int N, int[][] trust) {
    // Handling of missed test case  
    if ( N == 1) {
          return 1;
      }
      
      HashSet<Integer> outDegree = new HashSet<>();
      Map<Integer, Integer> inDegree = new HashMap<>();
      
      for (int[] rel : trust) {
          outDegree.add(rel[0]);
          
          if (inDegree.containsKey(rel[0])) inDegree.remove(rel[0]);
          
          if (outDegree.contains(rel[1])) {
              if (inDegree.containsKey(rel[1])) inDegree.remove(rel[1]);
          } else inDegree.put(rel[1], inDegree.getOrDefault(rel[1], 0) + 1);
      }
            
      for (int key : inDegree.keySet()) {
          if (inDegree.get(key) ==  N - 1) return key;
      }
      
      return -1;
      
  }
}


/**
 * Soliution 2:
 * 
 * LeetCode Execution: No Problem (Better Than the previous one, Time: 94.27%, Space: 100 %)
 * 
 * Time Complexity: o(n)
 * Space Complexity: O(n)
 *  
 */

class Solution {
  public int findJudge(int N, int[][] trust) {
      
      if (trust.length < N - 1) {
          return -1;
      }
      
      int[] inDegree = new int[N+1];
      int[] outDegree = new int[N+1];
      
      for (int[] t : trust ) {
          outDegree[t[0]] += -1;
          inDegree[t[1]] += 1; 
      }
      
      for (int i = 1; i <= N; i++ ) {
          if (outDegree[i] == 0 && inDegree[i] == N-1) {
              return i;
          }
      }
      
      return -1;
      
  }
}