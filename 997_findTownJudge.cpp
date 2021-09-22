// Time Complexity : O(V+E) where V is the number of person and E is the length of the array
// Space Complexity :O(V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        if(n == 0)
            return -1;
        vector<int> indegrees (n);
        for(vector<int> t : trust){
            indegrees[t[0]-1]--;
            indegrees[t[1]-1]++;
        }
        for(int i=0; i<n; i++){
            if(indegrees[i] == n-1)
                return i+1;
        }
        return -1;
    }
};
