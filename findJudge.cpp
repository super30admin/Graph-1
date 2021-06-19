// Time Complexity :O(n) where n is the number of edges and vertices
// Space Complexity : O(n)  //indegree array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        if(!trust.size() && n ==1) return 1;
        vector<int> inDegree(n+1,0);
        for(auto t : trust){
            inDegree[t[0]] -=1;
            inDegree[t[1]] +=1;
        }
        for(int i = 0;i<inDegree.size();i++){
            if(inDegree[i] == n-1) return i;
        }
        return -1;
    }
};