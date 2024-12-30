// Time Complexity - O(n + t)
// Space Complexity - O(n)

class Solution {
  public int findJudge(int n, int[][] trust) {
    int result = 0;
    int[] indegree = new int[n+1];
    for(int[] arr: trust) {
      indegree[arr[1]]++;
    }
    for(int i = 0; i<n+1; i++) {
      if(indegree[i] == n-1) {
        result = i;
      }
    }
    if(result > 0) {
      for(int[] arr: trust) {
        if(arr[0] == result) return -1;
      }
    }
    if(result > 0) return result;
    else return -1;
  }
}

// class Solution {
//     public int findJudge(int n, int[][] trust) {
//         if (n == 1 && trust.length == 0) {
//             return 1;
//         }
//         int[] indegree = new int[n+1];
//         for(int[] arr: trust) {
//             indegree[arr[0]]--;
//             indegree[arr[1]]++;
//         }
//         for(int i = 0; i<n+1; i++) {
//             if(indegree[i] == n-1) {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }