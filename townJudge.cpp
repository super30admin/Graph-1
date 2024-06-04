//Time = O(n) number of edges
//Space = O(n)
//Leetcode : yes
//issue seen: none
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> indegree(n+1, 0);
        if(!trust.size() && n ==1) return 1;
        for(int i=0; i< trust.size(); i++){
            indegree[trust[i][0]]--;
            indegree[trust[i][1]]++;
        }
        for(int i =1; i<=n; i++){
            if(indegree[i] == n-1){
                return i;
            }
        }
        return -1;
    }
};
