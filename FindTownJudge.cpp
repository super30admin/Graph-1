// Time Complexity - O(V+E)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> indegrees(n);
        
        for(vector<int> t : trust){
            indegrees[t[0] - 1]--;
            indegrees[t[1] - 1]++;
        }
        for(int i = 0; i < n; i++){
            if(indegrees[i] == n-1)
                return i+1;
        }
        return -1;
    }
};

// Same thing as above
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> indegrees(n+1);
        int size = trust.size();
        if(size == 0 && n == 1)
            return n;
        for(int i = 0; i < size; i++){
            vector<int> curr = trust[i];
            indegrees[curr[0]]--;
            indegrees[curr[1]]++;
        }
        for(int i = 0; i < n+1; i++){
            if(indegrees[i] == n-1)
                return i;
        }
        return -1;
    }
};