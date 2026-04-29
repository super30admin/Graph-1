   /**
    Time Complexity : O(N + T)
    Explanation:
    N = number of people
    T = number of trust relationships
    We process all trust pairs once and then scan the array once.

    Space Complexity : O(N)
    Explanation:
    We use an array of size N+1 to track trust scores.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially tried graph traversal which was unnecessary.
    Then realized judge conditions:
        - trusts nobody → outdegree = 0
        - trusted by everyone else → indegree = N-1
    Combined both into one array:
        indegree[i] = (#people trust i) - (#i trusts others)
    So judge will have value = N - 1.
    */

    class Solution {

        public int findJudge(int n, int[][] trust) {
    
            int[] indegrees = new int[n + 1];
            for (int i = 0; i < trust.length; i++) 
            {
                // person who trusts → decrease
                indegrees[trust[i][0]]--;
                // person who is trusted → increase
                indegrees[trust[i][1]]++;
            }
            // Find person trusted by n-1 and trusts nobody
            for (int i = 1; i <= n; i++) {
                if (indegrees[i] == n - 1) {
                    return i;
                }
            }
    
            return -1;
        }
    }