// Time Complexity : O(V+E)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        if(N==0){
            return -1;
        }
        vector<int> indegree(N);
        for(vector<int> trusts: trust){
            indegree[trusts[0]-1]--;
            indegree[trusts[1]-1]++;
        }
        for(int i=0;i<N;i++){
            if(indegree[i]==N-1){
                return i+1;
            }
        }
        return -1;
    }
};
