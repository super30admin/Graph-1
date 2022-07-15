// Time Complexity : O(v + e) 
// Space Complexity : O(v)
//          where v :- Number of vertex, 
//                e :- Number of edges
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Iterate over trust array, while iterating maintain a separate indegree array.
 * For each edge decrement the indegree of starting point of that edge 
 * and increment the indegree of ending point of that edge.
 * At the end iterate over indegree array, and if there is vertex with value v - 1 then that vertex is judge.  
 */

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        if (n == 0)
        {
            return -1;
        }
        
        int indeg[n];
        for (int i = 0; i < n; i++)
        {
            indeg[i] = 0;
        }
        
        for (auto& edge : trust)
        {
            indeg[edge[0] - 1]--;
            indeg[edge[1] - 1]++;
        }
        
        for (int i = 0; i < n; i++)
        {
            if (indeg[i] == n - 1)
            {
                return i+1;
            }
        }
        
        return -1;
    }
};