//Time: O(N)
//Space: O(N)
class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        vector<int> indegree(N,0);
        for(vector<int>i:trust){
            indegree[i[0]-1]--;
            indegree[i[1]-1]++;
        }
        
        for(int i=0; i<indegree.size(); i++){
            if(indegree[i] == N-1){
                return i+1;
            }
        }
        return -1;
    }
};