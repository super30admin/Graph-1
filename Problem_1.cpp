// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Find the Town Judge
// Approach: Graph 
// Time Complexity: O(T + N)
// Space Complexity: O(N)

class Solution {
    public:
        int findJudge(int n, vector<vector<int>>& trust) {
            if (n == 0) {
                return -1;
            }
    
            vector<int> indegrees(n, 0);  
            for (const auto& t : trust) {
                indegrees[t[0] - 1]--;  
                indegrees[t[1] - 1]++;  
            }
    
            for (int i = 0; i < n; i++) {
                if (indegrees[i] == n - 1) {  
                    return i + 1;
                }
            }
    
            return -1;  
        }
    };
    