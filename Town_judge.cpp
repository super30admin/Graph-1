// Time Complexity: O(V+E)
// Space Complexity: O(V)
// Did this code successfully run on Leetcode : Yes

//Approach: 
// 1. Create a vector of size n+1 to store the degree of each node.
// 2. Iterate through the trust vector and decrement the degree of the node at index 0 and increment the degree of the node at index 1.
// 3. Iterate through the degree vector and return the node with degree n-1.
// 4. If no such node is found, return -1.

class Solution {
    public:
        int findJudge(int n, vector<vector<int>>& trust) {
            vector<int> Degree(n + 1, 0);
            for(vector<int>& iter : trust){
                Degree[iter[0]]--;
                Degree[iter[1]]++;
            }
            
            for(int i = 1; i < Degree.size(); i++){
                if(Degree[i] == n - 1){
                    return i;
                }
            }
            return -1;
        }
    };