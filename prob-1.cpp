// t-c: v+e
//s-c: v
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> trustMap(n);
        for(int i = 0; i < trust.size(); i++){
            trustMap[trust[i][1] - 1]++;
            trustMap[trust[i][0] - 1]--;
        }
        for(int i = 0; i < n; i++){
            if(trustMap[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
};
