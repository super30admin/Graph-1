// Time Complexity : O(V+E)
// Space Complexity: O(V)
class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        vector<int> degrees(N, 0);
        for(int i = 0; i < trust.size(); i++) {
            degrees[trust[i][0]-1]--;
            degrees[trust[i][1]-1]++;
        }
        for(int i = 0; i < N; i++) {
            if(degrees[i] == N-1) {
                return i+1;
            }
        }
        return -1;
    }
};
